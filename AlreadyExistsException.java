import java.lang.Exception;

//���������� ������ ��� �� ���������� �� �������������� ��� custom exception ���
public class AlreadyExistsException extends Exception {

	public AlreadyExistsException (String message) {
		super(message);   //������� �� ������ ��� ������ ����� ���� ������� ����� ��� exception
	}
}
