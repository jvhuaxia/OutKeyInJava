import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Throwable {
		Thread.sleep(1000);
		InputStream is = Main.class.getResourceAsStream("outKey.txt");
		outKey(line2Space(inputStream2String(is)));
	}

	public static String line2Space(String string) {
		StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(string);
		while (scanner.hasNextLine()) {
			sb.append(scanner.nextLine());
			sb.append(" ");
		}
		return sb.toString();
	}

	public static String inputStream2String(InputStream is) throws IOException {
		int readWhere = -1;
		byte[] buff = new byte[1024];
		StringBuilder sb = new StringBuilder();
		while (-1 != (readWhere = is.read(buff))) {
			sb.append(new String(buff, 0, readWhere));
		}
		return sb.toString();
	}

	public static void outKey(String string) throws AWTException {
		Robot ro = new Robot();
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c >= 'a' && c <= 'z') {
				outKey(ro, c - 32);
			} else if (c >= 'A' && c <= 'Z') {
				outUpperKey(ro, c);
			} else if (c == '!') {
				outUpperKey(ro, KeyEvent.VK_1);
			} else if (c == '\'') {
				outKey(ro, 222);
			} else {
				outKey(ro, c);
			}
		}
	}

	public static void outUpperKey(Robot robot, int key) {
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(key);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(key);
	}

	public static void outKey(Robot robot, int key) {
		robot.keyPress(key);
		robot.keyRelease(key);
	}
}
