package menu;

import static functional.Functional.*;

public class DistributionMenu extends BaseMenu {

	@Override
	public void showMenu() {
		System.out.println("enter");
		System.out.println("DTBExample choose - 1");
		System.out.println("CollectionExample choose - 2");
		nextStep();
	}

	private void nextStep() {
		super.setChooseOperation(scanner.next());
		switch (getChooseOperation()) {
		case "1":
			initFunctionalDTB();
			authorization = new MenuAuthorization();
			authorization.showMenu();
			break;
		case "2":
			initFunctionalCollection();
			authorization = new MenuAuthorization();
			authorization.showMenu();
			break;
		case "3":
			System.exit(0);
			break;
		default:
			System.out.println("Wrong choose Try again");
			showMenu();
		}

	}

}
