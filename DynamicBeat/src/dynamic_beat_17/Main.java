package dynamic_beat_17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;

import javax.swing.JFrame;

import javax.swing.JPanel;
import dynamic_beat_17.control.DynamicBeat;
import dynamic_beat_17.view.Login;
import dynamic_beat_17.view.SignUp;



public class Main extends JFrame{
	public static final int SCREEN_WIDTH = 1280;  //final은 한번 선언하면 절대 안바뀜, 상수는 전부 대문자
	public static final int SCREEN_HEIGHT = 750;
	public static final int NOTE_SPEED = 3;  //노트의 속도는 7
	public static final int SLEEP_TIME = 5; //노트가 10 주기로 떨어짐
	public static final int REACH_TIME = 4; //노트가 생성된 후 판정바에 도달하기 까지의 시간
	
	public Login login = null;
	public SignUp signUp = null;
	public DynamicBeat dynamicBeat = null;
	
	public Main() throws SQLException {
		this.login = new Login(this);
		this.signUp = new SignUp(this);
		this.dynamicBeat = new DynamicBeat(this);
		
		this.add(this.login);
//		this.add(this.dynamicBeat);

		
		this.setTitle("Dynamic Beat");
		this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		this.setResizable(false); // 한번 만들어진 창은 사용자가 임의로 줄이거나 늘릴 수 없다.
		this.setLocationRelativeTo(null); // 실행시 게임 화면이 정 중앙에 뜨게 설정
//		win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 창닫으면 노래나옴
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 전체 종료
		this.setVisible(true);
	}
	
	public void change(String panelName) {
		
		
		if(panelName.equals("login")) {
			getContentPane().removeAll();
			getContentPane().add(login);
			revalidate();
			repaint();
		}else if(panelName.equals("signUp")) {
			getContentPane().removeAll();
			getContentPane().add(signUp);
			revalidate();
			repaint();
		}else if(panelName.equals("dynamicBeat")) {
			getContentPane().removeAll();
			getContentPane().add(dynamicBeat);
			revalidate();
			repaint();
		}
	}
	
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		
		File file = new File("d:/log.txt");
		PrintStream printStream = new PrintStream(new FileOutputStream(file));
		// standard out과 err을 file로 변경
		System.setOut(printStream);
		System.setErr(printStream);

		
		Main win = new Main();
		
		
	}

}
