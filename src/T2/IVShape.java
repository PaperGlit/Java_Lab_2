package T2;

public interface IVShape extends IShape {
    @SuppressWarnings("unused")
    default double V() {
        return 0;
    }
}
