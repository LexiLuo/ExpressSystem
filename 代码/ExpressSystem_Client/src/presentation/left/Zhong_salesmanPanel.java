package presentation.left;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import businesslogic.systembl.SystemHelper;
import businesslogicservice.systemblservice.systemServer;
import presentation.Data;
import presentation.watcher.*;

public class Zhong_salesmanPanel extends LeftAll implements ActionListener {

	private List<Watcher> list;
	int frameWidth;
	int frameHeight;
	JButton[] jb;
	JButton logout;
	JButton close;
	JPanel picture;
	JLabel name;
	JLabel num;
	JLabel photo;

	JTextField jtf_num;
	JTextField jtf_name;

	public Zhong_salesmanPanel(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(0, 0, frameWidth / 4, frameHeight);

		jb = new JButton[3];
		for (int i = 0; i < 3; i++) {
			jb[i] = new JButton();
		}
		logout = new JButton();// "登出账号"
		close = new JButton();// "关闭系统"
		logout.setContentAreaFilled(false);
		close.setContentAreaFilled(false);
		logout.setBorderPainted(false);
		close.setBorderPainted(false);
		logout.addActionListener(this);
		close.addActionListener(this);

		jtf_name = new JTextField();
		jtf_num = new JTextField();

		init();

		this.setBackground(new Color(248, 147, 69));
		for (int i = 0; i < 3; i++) {
			this.add(jb[i]);
		}
		this.add(logout);
		this.add(close);
		this.add(jtf_name);
		this.add(jtf_num);

	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\zhongleft1.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth / 4, frameHeight, null);
	}

	private void init() {
		for (int i = 0; i < 3; i++) {
			jb[i] = new JButton();
			jb[i].setBounds(0, frameHeight / 3 + frameHeight / 13 * i,
					frameWidth / 4, frameHeight / 13);

			// jb[i].setContentAreaFilled(false);
			jb[i].addActionListener(this);
		}

		ImageIcon icon0 = new ImageIcon("pictures//到达单填写.png");
		Image temp0 = icon0.getImage().getScaledInstance(jb[0].getWidth(),
				jb[0].getHeight(), icon0.getImage().SCALE_DEFAULT);
		icon0 = new ImageIcon(temp0);
		jb[0].setIcon(icon0);

		ImageIcon icon1 = new ImageIcon("pictures//中转单填写.png");
		Image temp1 = icon1.getImage().getScaledInstance(jb[1].getWidth(),
				jb[1].getHeight(), icon1.getImage().SCALE_DEFAULT);
		icon1 = new ImageIcon(temp1);
		jb[1].setIcon(icon1);

		ImageIcon icon2 = new ImageIcon("pictures//装车单填写.png");
		Image temp2 = icon2.getImage().getScaledInstance(jb[2].getWidth(),
				jb[2].getHeight(), icon2.getImage().SCALE_DEFAULT);
		icon2 = new ImageIcon(temp2);
		jb[2].setIcon(icon2);

		jb[0].setText("");// 到达单填写
		jb[1].setText("");// 中转单填写
		jb[2].setText("");// 装车单填写

		logout.setMargin(new Insets(0, 0, 0, 0));
		logout.setBounds(frameWidth * 3 / 80, frameHeight * 63 / 72,
				frameWidth / 17, frameWidth / 17);
		close.setMargin(new Insets(0, 0, 0, 0));
		close.setBounds(frameWidth * 13 / 80, frameHeight * 63 / 72,
				frameWidth / 17, frameWidth / 17);

		jtf_name.setBounds(frameWidth / 10, frameHeight / 64 * 15,
				frameWidth / 10, frameHeight / 30);
		jtf_num.setBounds(frameWidth / 10, frameHeight / 64 * 18,
				frameWidth / 10, frameHeight / 30);
		
		jtf_name.setText(SystemHelper.getUserName());
		jtf_name.setEditable(false);
		jtf_num.setText(SystemHelper.getUserID());
		jtf_num.setEditable(false);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb[0]) {
			this.notifyWatchers(State.ZHONG_ARRIVAL);
		} else if (e.getSource() == jb[1]) {
			this.notifyWatchers(State.ZHONG_TRANSFER);
		} else if (e.getSource() == jb[2]) {
			this.notifyWatchers(State.ZHONG_ENTRUCKING);
		} else if (e.getSource() == logout) {
			this.notifyWatchers(State.LOGOUT);
		} else if (e.getSource() == close) {
			System.exit(0);
		}

	}

	public void addWatcher(Watcher watcher) {
		list.add(watcher);
	}

	public void removeWatcehr(Watcher watcher) {
		list.remove(watcher);
	}

	public void notifyWatchers(State state) {
		for (Watcher watcher : list) {
			watcher.update(state);
		}
	}
}
