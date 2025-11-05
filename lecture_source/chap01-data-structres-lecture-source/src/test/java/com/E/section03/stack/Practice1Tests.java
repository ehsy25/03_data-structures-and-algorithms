package com.E.section03.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/*괄호 백준 9012*/
class Practice1Tests {

    Practice1 p1;

    @BeforeEach
    void setUp() {
        p1 = new Practice1();
    }

    static Stream<Arguments> provideTestCases(){
        return Stream.of(
          Arguments.arguments("(())())", "NO"),
          Arguments.arguments("(((()())()", "NO"),
          Arguments.arguments("(()())((()))", "YES"),
          Arguments.arguments("((()()(()))(((())))()", "NO"),
          Arguments.arguments("()()()()(()()())()", "YES"),
          Arguments.arguments("(()((())()(", "NO")
        );
    }
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testeParenthesisString(String input, String expected){
        String result = p1.solution(input);
        Assertions.assertEquals(expected,result);
    }

}