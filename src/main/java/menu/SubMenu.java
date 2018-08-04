package menu;

public class SubMenu extends BaseMenu {
	BaseMenu menu;

	public SubMenu() {
		super();
	}

	public SubMenu(BaseMenu menu) {
		super();
		this.menu = menu;
	}

	@Override
	void showMenu() {
		System.out.println("Do you want to return? - choose 1");
		System.out.println("Do you want to exit? choose 2");
		nextStep();
	}

	public void showReceivedMenu() {
		menu.showMenu();
	}

	private void nextStep() {
		super.setChooseOperation(scanner.next());
		switch (getChooseOperation()) {
		case "1":
			showReceivedMenu();
			break;
		case "2":
			System.exit(0);
			break;
		default:
			System.out.println("Wrong choose Try again");
			showMenu();
		}
	}

}
