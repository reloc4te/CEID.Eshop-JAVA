import java.lang.Exception;

//���������� ������ ��� �� ���������� �� �������������� ��� custom exception ���
public class StockNotFoundException extends Exception {

	public StockNotFoundException (String message) {
		super(message);   //������� �� ������ ��� ������ ����� ���� ������� ����� ��� exception
	}
}
