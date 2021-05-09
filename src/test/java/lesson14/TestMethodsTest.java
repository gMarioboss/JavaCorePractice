package lesson14;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

    class TestMethodsTest {
        TestMethods testMethods;

        @BeforeEach
        void init() {
            testMethods = new TestMethods();
        }

        @DisplayName("Проверка исключения findNumbersException")
        @Test
        void findExceptionTest () {
            Assertions.assertThrows(RuntimeException.class, () -> {
                Assertions.assertArrayEquals(new int[]{1, 2, 3, 5, 2, 3, 1, 1, 7}, testMethods.findNumbers(new int[]{1, 2, 3, 5, 2, 3, 1, 1, 7}));
            });
        }

        @DisplayName("Параметризированный тест findNumbers")
        @ParameterizedTest
        @MethodSource("data")
        void findParamTest (int[] exp, int[] actual) {
                Assertions.assertArrayEquals(exp, testMethods.findNumbers(actual));
        }

        static Stream<Arguments> data() {
            return Stream.of(
                    Arguments.arguments(new int[]{2,3,1,1,7}, new int[]{1, 2, 5, 4, 2, 3, 1, 1, 7}),
                    Arguments.arguments(new int[]{1,7}, new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}),
                    Arguments.arguments(new int[]{2, 3, 5, 2, 3, 1, 1, 7}, new int[]{4, 2, 3, 5, 2, 3, 1, 1, 7}),
                    Arguments.arguments(new int[]{2,1,7}, new int[]{1, 4, 4, 3, 2, 4, 2, 1, 7})
            );
        }

        @DisplayName("Параметризированный тест checkNumbers")
        @ParameterizedTest
        @MethodSource("data2")
        void findParamTest (boolean exp, int[] actual) {
            Assertions.assertEquals(exp, testMethods.checkNumbers(actual));
        }

        static Stream<Arguments> data2() {
            return Stream.of(
                    Arguments.arguments(true, new int[]{1, 1, 1 ,4, 4, 1, 4, 4}),
                    Arguments.arguments(false, new int[]{1, 1, 1, 1, 1, 1}),
                    Arguments.arguments(false, new int[]{4, 4, 4, 4}),
                    Arguments.arguments(false, new int[]{1, 4, 4, 1, 1, 4, 3})
            );
        }
    }
