/* I Got Bored
/////////////////////////////////////////
*****************************************
-----------------------------------------
|			Rajiv Ahmed					|
|			W1431880					|
|	BSc (Hons) Computer Network Security|
|										|
|	University of Westminster			|
|			EECT520						|
|	Event Driven & GUI Programming		|
-----------------------------------------
*****************************************
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VirtKeyB implements ActionListener, ItemListener 
{
	JFrame kbwin;
	Robot rob;
	JPanel rPan, lPan;
	JToggleButton tglBtns[];
	JButton rBtn[], lBtn[];
	String tglBtnNames[] = 
	{ 
		"Caps	", "Shift	", "Ctrl	", "Alt		"
	};

	String rBtnNames[] = 
	{ 
		"Home	", "PgUp	", "End		", "PgDn	"
	};

	String lBtnNames[] = 
	{ 
		"Esc	", "F1 ", "F2 ", "F3 ", "F4 ", "F5 ", "F6 ", "F7 ", "F8 ", "F9 ", "F10", "F11", "F12", 
		"~`", "!1", "@2", "#3", "$4", "%5", "^6", "&7", "*8", "( 9", ") 0", "- _", "+ = ", "Bksp", "Tab		", 
		"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "{ [", "} ]", "Del	", 
		"a", "s", "d", "f", "g", "h", "j", "k", "l", " : ; ", " \" ' "," Enter		", 
		"z", "x", "c", "v", "b", "n", "m", "< ,", "> .", "?/ ", "Windows", "Space				"
	};

	public VirtKeyB() 
	{
		kbwin = new JFrame("Java - Virtual Keyboard");
		kbwin.setAlwaysOnTop(true);
		kbwin.setSize(800, 250);
		kbwin.setLocationRelativeTo(null);
		kbwin.setFocusableWindowState(false);
		kbwin.add(BgPan());
		kbwin.add(SmlPan());
		kbwin.setVisible(true);
	}

	JPanel SmlPan() 
	{
		rPan = new JPanel();
		rBtn = new JButton[rBtnNames.length];
		for (int i = 0; i < rBtnNames.length; i++) 
		{
			rBtn[i] = new JButton(rBtnNames[i]);
			rBtn[i].setBackground(Color.GRAY);
			rBtn[i].setForeground(Color.BLUE);
			rBtn[i].addActionListener(this);
			rPan.add(rBtn[i]);
		}
		rPan.setBounds(790, 0, 180, 180);
		return rPan;
	}

	private JPanel BgPan() 
	{
		lPan = new JPanel();
		tglBtns = new JToggleButton[tglBtnNames.length];
		for (int i = 0; i < tglBtnNames.length; i++) 
		{
			tglBtns[i] = new JToggleButton(tglBtnNames[i]);
			tglBtns[i].setBackground(Color.DARK_GRAY);
			tglBtns[i].setForeground(Color.WHITE);
			tglBtns[i].addItemListener(this);
		}

		lBtn = new JButton[lBtnNames.length];
		for (int i = 0; i < lBtnNames.length; i++) 
		{
			lBtn[i] = new JButton(lBtnNames[i]);
			lBtn[i].setBackground(Color.DARK_GRAY);
			lBtn[i].setForeground(Color.WHITE);
			lBtn[i].addActionListener(this);
			
			lPan.add(lBtn[i]);
			switch (i) 
			{
				case 41:
					lPan.add(tglBtns[0]);
					break;

				case 53:
					lPan.add(tglBtns[1]);
					break;

				case 64:
					lPan.add(tglBtns[2]);
					lPan.add(tglBtns[3]);
					break;

				case 65:
					lPan.add(tglBtns[4]);
					break;

				case 66:
					lPan.add(tglBtns[5]);
					lPan.add(tglBtns[6]);
					break;

				case 69:
					lPan.add(tglBtns[7]);
					break;
			}
			lPan.setBounds(0, 0, 750, 190);
		}
		return lPan;
	}

	public void actionPerformed(ActionEvent e) 
	{
		try 
		{
			rob = new Robot();

			if (e.getSource() == lBtn[0])
				rob.keyPress(KeyEvent.VK_ESCAPE);

			if (e.getSource() == lBtn[1])
				rob.keyPress(KeyEvent.VK_F1);

			if (e.getSource() == lBtn[2])
				rob.keyPress(KeyEvent.VK_F2);

			if (e.getSource() == lBtn[3])
				rob.keyPress(KeyEvent.VK_F3);

			if (e.getSource() == lBtn[4])
				rob.keyPress(KeyEvent.VK_F4);

			if (e.getSource() == lBtn[5])
				rob.keyPress(KeyEvent.VK_F5);

			if (e.getSource() == lBtn[6])
				rob.keyPress(KeyEvent.VK_F6);

			if (e.getSource() == lBtn[7])
				rob.keyPress(KeyEvent.VK_F7);

			if (e.getSource() == lBtn[8])
				rob.keyPress(KeyEvent.VK_F8);

			if (e.getSource() == lBtn[9])
				rob.keyPress(KeyEvent.VK_F9);

			if (e.getSource() == lBtn[10])
				rob.keyPress(KeyEvent.VK_F10);

			if (e.getSource() == lBtn[11])
				rob.keyPress(KeyEvent.VK_F11);

			if (e.getSource() == lBtn[12])
				rob.keyPress(KeyEvent.VK_F12);

			if (e.getSource() == lBtn[13])
				rob.keyPress(KeyEvent.VK_BACK_QUOTE);

			if (e.getSource() == lBtn[14])
				rob.keyPress(KeyEvent.VK_1);

			if (e.getSource() == lBtn[15])
				rob.keyPress(KeyEvent.VK_2);

			if (e.getSource() == lBtn[16])
				rob.keyPress(KeyEvent.VK_3);

			if (e.getSource() == lBtn[17])
				rob.keyPress(KeyEvent.VK_4);

			if (e.getSource() == lBtn[18])
				rob.keyPress(KeyEvent.VK_5);

			if (e.getSource() == lBtn[19])
				rob.keyPress(KeyEvent.VK_6);

			if (e.getSource() == lBtn[20])
				rob.keyPress(KeyEvent.VK_7);

			if (e.getSource() == lBtn[21])
				rob.keyPress(KeyEvent.VK_8);

			if (e.getSource() == lBtn[22])
				rob.keyPress(KeyEvent.VK_9);

			if (e.getSource() == lBtn[23])
				rob.keyPress(KeyEvent.VK_0);

			if (e.getSource() == lBtn[24])
				rob.keyPress(KeyEvent.VK_MINUS);

			if (e.getSource() == lBtn[25])
				rob.keyPress(KeyEvent.VK_EQUALS);

			if (e.getSource() == lBtn[26])
				rob.keyPress(KeyEvent.VK_BACK_SPACE);

			if (e.getSource() == lBtn[27])
				rob.keyPress(KeyEvent.VK_TAB);

			if (e.getSource() == lBtn[28])
				rob.keyPress(KeyEvent.VK_Q);

			if (e.getSource() == lBtn[29])
				rob.keyPress(KeyEvent.VK_W);

			if (e.getSource() == lBtn[30])
				rob.keyPress(KeyEvent.VK_E);

			if (e.getSource() == lBtn[31])
				rob.keyPress(KeyEvent.VK_R);

			if (e.getSource() == lBtn[32])
				rob.keyPress(KeyEvent.VK_T);

			if (e.getSource() == lBtn[33])
				rob.keyPress(KeyEvent.VK_Y);

			if (e.getSource() == lBtn[34])
				rob.keyPress(KeyEvent.VK_U);

			if (e.getSource() == lBtn[35])
				rob.keyPress(KeyEvent.VK_I);

			if (e.getSource() == lBtn[36])
				rob.keyPress(KeyEvent.VK_O);

			if (e.getSource() == lBtn[37])
				rob.keyPress(KeyEvent.VK_P);

			if (e.getSource() == lBtn[38])
				rob.keyPress(KeyEvent.VK_OPEN_BRACKET);

			if (e.getSource() == lBtn[39])
				rob.keyPress(KeyEvent.VK_CLOSE_BRACKET);

			if (e.getSource() == lBtn[40])
				rob.keyPress(KeyEvent.VK_DELETE);

			if (e.getSource() == lBtn[41])
				rob.keyPress(KeyEvent.VK_A);

			if (e.getSource() == lBtn[42])
				rob.keyPress(KeyEvent.VK_S);

			if (e.getSource() == lBtn[43])
				rob.keyPress(KeyEvent.VK_D);

			if (e.getSource() == lBtn[44])
				rob.keyPress(KeyEvent.VK_F);

			if (e.getSource() == lBtn[45])
				rob.keyPress(KeyEvent.VK_G);

			if (e.getSource() == lBtn[46])
				rob.keyPress(KeyEvent.VK_H);

			if (e.getSource() == lBtn[47])
				rob.keyPress(KeyEvent.VK_J);

			if (e.getSource() == lBtn[48])
				rob.keyPress(KeyEvent.VK_K);

			if (e.getSource() == lBtn[49])
				rob.keyPress(KeyEvent.VK_L);

			if (e.getSource() == lBtn[50])
				rob.keyPress(KeyEvent.VK_SEMICOLON);

			if (e.getSource() == lBtn[51])
				rob.keyPress(KeyEvent.VK_QUOTE);

			if (e.getSource() == lBtn[52])
				rob.keyPress(KeyEvent.VK_ENTER);

			if (e.getSource() == lBtn[53])
				rob.keyPress(KeyEvent.VK_Z);

			if (e.getSource() == lBtn[54])
				rob.keyPress(KeyEvent.VK_X);

			if (e.getSource() == lBtn[55])
				rob.keyPress(KeyEvent.VK_C);

			if (e.getSource() == lBtn[56])
				rob.keyPress(KeyEvent.VK_V);

			if (e.getSource() == lBtn[57])
				rob.keyPress(KeyEvent.VK_B);

			if (e.getSource() == lBtn[58])
				rob.keyPress(KeyEvent.VK_N);

			if (e.getSource() == lBtn[59])
				rob.keyPress(KeyEvent.VK_M);

			if (e.getSource() == lBtn[60])
				rob.keyPress(KeyEvent.VK_COMMA);

			if (e.getSource() == lBtn[61])
				rob.keyPress(KeyEvent.VK_PERIOD);

			if (e.getSource() == lBtn[62])
				rob.keyPress(KeyEvent.VK_SLASH);

			if (e.getSource() == lBtn[63]) 
			{
				rob.keyPress(KeyEvent.VK_WINDOWS);
				rob.keyRelease(KeyEvent.VK_WINDOWS);
			}

			if (e.getSource() == lBtn[64])
				rob.keyPress(KeyEvent.VK_SPACE);

			if (e.getSource() == rBtn[0])
				rob.keyPress(KeyEvent.VK_HOME);

			if (e.getSource() == rBtn[1])
				rob.keyPress(KeyEvent.VK_PAGE_UP);

			if (e.getSource() == rBtn[2])
				rob.keyPress(KeyEvent.VK_END);

			if (e.getSource() == rBtn[3])
				rob.keyPress(KeyEvent.VK_PAGE_DOWN);
		} 
		catch (AWTException ex) 
		{
			ex.printStackTrace();
		}
	}

	public void itemStateChanged(ItemEvent ev) 
	{
		try 
		{
			rob = new Robot();

			if (ev.getStateChange() == ItemEvent.SELECTED && ev.getSource() == tglBtns[0]) 
			{
				ToUp();
				tglBtns[0].setForeground(Color.BLACK);
				Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, true);
			} 
			else if (ev.getStateChange() == ItemEvent.DESELECTED && ev.getSource() == tglBtns[0]) 
			{
				ToLow();
				tglBtns[0].setForeground(Color.WHITE);
				Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, false);
			}
			if (ev.getStateChange() == ItemEvent.SELECTED && ev.getSource() == tglBtns[1]) 
			{
				rob.keyPress(KeyEvent.VK_SHIFT);
				tglBtns[1].setForeground(Color.BLACK);
			}
			else if (ev.getStateChange() == ItemEvent.DESELECTED && ev.getSource() == tglBtns[1]) 
			{
				rob.keyRelease(KeyEvent.VK_SHIFT);
				tglBtns[1].setForeground(Color.WHITE);
			}

			if (ev.getStateChange() == ItemEvent.SELECTED && ev.getSource() == tglBtns[2]) 
			{
				rob.keyPress(KeyEvent.VK_SHIFT);
				tglBtns[2].setForeground(Color.BLACK);
			}

			else if (ev.getStateChange() == ItemEvent.DESELECTED && ev.getSource() == tglBtns[2]) 
			{
				rob.keyRelease(KeyEvent.VK_SHIFT);
				tglBtns[2].setForeground(Color.WHITE);
			}

			if (ev.getStateChange() == ItemEvent.SELECTED && ev.getSource() == tglBtns[3]) 
			{
				rob.keyPress(KeyEvent.VK_CONTROL);
				tglBtns[3].setForeground(Color.BLACK);
			}

			else if (ev.getStateChange() == ItemEvent.DESELECTED && ev.getSource() == tglBtns[3]) 
			{
				rob.keyRelease(KeyEvent.VK_CONTROL);
				tglBtns[3].setForeground(Color.WHITE);
			}

			if (ev.getStateChange() == ItemEvent.SELECTED && ev.getSource() == tglBtns[4]) 
			{
				rob.keyPress(KeyEvent.VK_ALT);
				tglBtns[4].setForeground(Color.BLACK);
			}
			else if (ev.getStateChange() == ItemEvent.DESELECTED && ev.getSource() == tglBtns[4]) 
			{
				rob.keyRelease(KeyEvent.VK_ALT);
				tglBtns[4].setForeground(Color.WHITE);
			}

			if (ev.getStateChange() == ItemEvent.SELECTED && ev.getSource() == tglBtns[5]) 
			{
				rob.keyPress(KeyEvent.VK_ALT);
				tglBtns[5].setForeground(Color.BLACK);
			} 
			else if ((ev.getStateChange() == ItemEvent.DESELECTED && ev.getSource() == tglBtns[5])) 
			{
				rob.keyRelease(KeyEvent.VK_ALT);
				tglBtns[5].setForeground(Color.WHITE);
			}

			if (ev.getStateChange() == ItemEvent.SELECTED && ev.getSource() == tglBtns[6]) 
			{
				rob.keyPress(KeyEvent.VK_CONTROL);
				tglBtns[6].setForeground(Color.BLACK);
			}
			else if (ev.getStateChange() == ItemEvent.DESELECTED && ev.getSource() == tglBtns[6]) 
			{
				rob.keyRelease(KeyEvent.VK_CONTROL);
				tglBtns[6].setForeground(Color.WHITE);
			}
		}
		catch (AWTException e) 
		{
			e.printStackTrace();
		}
	}
	
	/*Low to Up*/
	public void ToUp() {
		for (int i = 28; i < lBtnNames.length - 32; i++) 
		{
			lBtn[i].setText(lBtnNames[i].toUpperCase());
			lBtn[27].setText("Tab      ");
		}

		for (int i = 42; i < lBtnNames.length - 19; i++) 
		{
			lBtn[i].setText(lBtnNames[i].toUpperCase());
			tglBtns[0].setText("Caps         ");
		}

		for (int i = 54; i < lBtnNames.length - 9; i++)
		{
			lBtn[i].setText(lBtnNames[i].toUpperCase());
			tglBtns[1].setText("Shift                ");
		}
	}

	/*Up to Low*/
	public void ToLow() 
	{
		for (int i = 28; i < lBtnNames.length - 32; i++) 
		{
			lBtn[i].setText(lBtnNames[i].toLowerCase());
			lBtn[27].setText("Tab           ");
		}

		for (int i = 42; i < lBtnNames.length - 19; i++) 
		{
			lBtn[i].setText(lBtnNames[i].toLowerCase());
			tglBtns[0].setText("Caps              ");
		}

		for (int i = 54; i < lBtnNames.length - 9; i++) 
		{
			lBtn[i].setText(lBtnNames[i].toLowerCase());
			tglBtns[1].setText("Shift                  ");
		}
	}

	public static void main() 
	{
		new VirtKeyB();
	}
}