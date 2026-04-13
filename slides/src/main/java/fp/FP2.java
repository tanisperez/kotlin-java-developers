interface Sum {
    int sum(int a, int b);
}

void main() {
    Sum sumFunction = (a, b) -> a + b;
    IO.println(sumFunction.sum(1, 2));
}
