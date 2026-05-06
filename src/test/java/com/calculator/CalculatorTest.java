package com.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    // ── Addition ──────────────────────────────────────────

    @Test
    @DisplayName("add: two positive numbers returns correct sum")
    void add_twoPositive_returnsSum() {
        assertEquals(10.0, calculator.add(3, 7));
    }

    @Test
    @DisplayName("add: negative operand returns correct sum")
    void add_negativeOperand_returnsSum() {
        assertEquals(2.0, calculator.add(-4, 6));
    }

    @Test
    @DisplayName("add: opposite numbers return zero")
    void add_opposites_returnsZero() {
        assertEquals(0.0, calculator.add(5, -5));
    }

    // ── Subtraction ───────────────────────────────────────

    @Test
    @DisplayName("subtract: two positive numbers returns correct difference")
    void subtract_twoPositive_returnsDifference() {
        assertEquals(6.0, calculator.subtract(10, 4));
    }

    @Test
    @DisplayName("subtract: b greater than a returns negative result")
    void subtract_largerB_returnsNegative() {
        assertEquals(-5.0, calculator.subtract(3, 8));
    }

    @Test
    @DisplayName("subtract: equal numbers return zero")
    void subtract_equalNumbers_returnsZero() {
        assertEquals(0.0, calculator.subtract(7, 7));
    }

    // ── Multiplication ────────────────────────────────────

    @Test
    @DisplayName("multiply: two positive numbers returns correct product")
    void multiply_twoPositive_returnsProduct() {
        assertEquals(12.0, calculator.multiply(3, 4));
    }

    @Test
    @DisplayName("multiply: one negative factor returns negative product")
    void multiply_oneNegative_returnsNegativeProduct() {
        assertEquals(-12.0, calculator.multiply(-3, 4));
    }

    @Test
    @DisplayName("multiply: any factor is zero returns zero")
    void multiply_byZero_returnsZero() {
        assertEquals(0.0, calculator.multiply(99, 0));
    }

    // ── Division ──────────────────────────────────────────

    @Test
    @DisplayName("divide: two positive numbers returns correct quotient")
    void divide_twoPositive_returnsQuotient() {
        assertEquals(5.0, calculator.divide(10, 2));
    }

    @Test
    @DisplayName("divide: non-divisible numbers returns decimal result")
    void divide_nonDivisible_returnsFraction() {
        assertEquals(3.5, calculator.divide(7, 2));
    }

    @Test
    @DisplayName("divide: divisor is zero throws ArithmeticException")
    void divide_byZero_throwsArithmeticException() {
        ArithmeticException ex = assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(5, 0)
        );
        assertEquals("Division by zero is not allowed", ex.getMessage());
    }
}
