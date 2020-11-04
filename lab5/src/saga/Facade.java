package saga;

import easyaccept.EasyAccept;

public class Facade {
	public static void main(String[] args) {
		args = new String[] {"saga.Facade", "acceptance_test/use_case_1.txt"};
		EasyAccept.main(args);
	}
}
