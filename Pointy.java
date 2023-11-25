import java.util.Objects;

public class Pointy {
    int x;
    int y;

    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public Pointy (int iX, int iY) {
        x = iX;
        y = iY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public double radius() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public int quadrant() {
        if (x > 0 && y > 0) {
            return 1;
        } else if (x < 0 && y > 0) {
            return 2;
        } else if (x < 0 && y < 0) {
            return 3;
        } else if (x > 0 && y < 0) {
            return 4;
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pointy pointy = (Pointy) o;
        return x == pointy.x && y == pointy.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public double distance(Pointy p2) {
        return Math.sqrt(Math.pow(x - p2.x, 2) + Math.pow(y - p2.y, 2));
    }
}
