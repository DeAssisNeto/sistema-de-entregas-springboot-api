package sistema.entregas.Exceptions;

public class RecordAlreadsExistsException extends RuntimeException {
    public RecordAlreadsExistsException(String field, String fieldName, String value) {

        super(String.format("Já existe um %s com %s = %s na base de dados", field, fieldName, value));
    }
}
