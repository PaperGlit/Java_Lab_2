package T2;

public interface VShape extends Shape {
    @SuppressWarnings("unused")
    default double V() {
        return 0;
    }
}
