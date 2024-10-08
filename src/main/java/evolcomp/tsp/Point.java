package evolcomp.tsp;

public record Point(int nodeId, int x, int y, int cost) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;
        return x == point.x && y == point.y && cost == point.cost;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = result + (46340 * y);
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "nodeId=" + nodeId +
                ", x=" + x +
                ", y=" + y +
                ", cost=" + cost +
                '}';
    }
}
