import java.io.IOException;

public interface MinhaSerializable {
    byte[] serializar() throws IOException;
    void desserializar(byte[] dados) throws IOException, ClassNotFoundException;
}
