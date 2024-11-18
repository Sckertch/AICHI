package def;

import Controler.Connexion;
import modele.UserDAO;
import views.FConnexionView;

public class main {

	public static void main(String[] args) {
		System.out.println("test");
		FConnexionView view = new FConnexionView();
		UserDAO userdao = new UserDAO();
		Connexion controler = new Connexion(view,userdao);

	}

}
