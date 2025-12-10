package io.github.mjcro.interfaces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

class StrongTypeTest {
    @SafeVarargs
    private static <T> HashSet<T> setOf(T... items) {
        return new HashSet<>(Arrays.asList(items));
    }

    @Test
    void testSimple() {
        SimpleStrongType t = new SimpleStrongType(SimpleEnum.TWO);

        Assertions.assertEquals(SimpleEnum.TWO, t.value());
        Assertions.assertEquals(SimpleEnum.TWO, t.getValue());

        Assertions.assertTrue(t.hasValue(SimpleEnum.TWO));
        Assertions.assertFalse(t.hasValue(SimpleEnum.ONE));

        Assertions.assertFalse(t.notHasValue(SimpleEnum.TWO));
        Assertions.assertTrue(t.notHasValue(SimpleEnum.ONE));

        Assertions.assertTrue(t.hasValueOneOf(SimpleEnum.ONE, SimpleEnum.TWO));
        Assertions.assertTrue(t.notHasValueOneOf(SimpleEnum.ONE, SimpleEnum.THREE));
        Assertions.assertTrue(t.hasValueOneOf(setOf(SimpleEnum.ONE, SimpleEnum.TWO)));
        Assertions.assertTrue(t.notHasValueOneOf(setOf(SimpleEnum.ONE, SimpleEnum.THREE)));

        Assertions.assertFalse(t.hasValueOneOf(SimpleEnum.ONE, SimpleEnum.THREE));
        Assertions.assertFalse(t.notHasValueOneOf(SimpleEnum.ONE, SimpleEnum.TWO));
        Assertions.assertFalse(t.hasValueOneOf(setOf(SimpleEnum.ONE, SimpleEnum.THREE)));
        Assertions.assertFalse(t.notHasValueOneOf(setOf(SimpleEnum.ONE, SimpleEnum.TWO)));
    }

    @Test
    void testCaseInsensitiveName() {
        CaseInsensitiveName n = new CaseInsensitiveName("Foo");

        Assertions.assertEquals("Foo", n.value());
        Assertions.assertEquals("Foo", n.getValue());

        Assertions.assertTrue(n.hasValue("FOO"));
        Assertions.assertTrue(n.hasValue("foo"));
        Assertions.assertTrue(n.notHasValue("bar"));

        Assertions.assertTrue(n.hasValueOneOf("foo", "bar"));
        Assertions.assertTrue(n.notHasValueOneOf("bar", "baz"));
    }

    private enum SimpleEnum {
        ONE, TWO, THREE
    }

    private static class SimpleStrongType implements StrongType<SimpleEnum> {
        private final SimpleEnum value;

        private SimpleStrongType(SimpleEnum value) {
            this.value = value;
        }

        @Override
        public SimpleEnum value() {
            return this.value;
        }
    }

    private static class CaseInsensitiveName implements StrongType<String> {
        private final String value;

        private CaseInsensitiveName(String value) {
            this.value = value;
        }

        @Override
        public String value() {
            return this.value;
        }

        @Override
        public boolean hasValue(String candidate) {
            return candidate != null && candidate.equalsIgnoreCase(value());
        }
    }
}