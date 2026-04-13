void main() {
    var result = Stream.of(1, 2, 3, 4)
        .filter(x -> x % 2 == 0)
        .map(x -> x * 2)
        .toList();

    IO.println(result);
}
