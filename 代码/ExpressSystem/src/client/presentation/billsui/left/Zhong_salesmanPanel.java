package client.presentation.billsui.left;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import client.presentation.billsui.Data;
import client.presentation.billsui.watcher.*;

public class Zhong_salesmanPanel extends JPanel implements Watched,
		ActionListener {

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
		logout = new JButton("登出账号");
		close = new JButton("关闭系统");
		picture = new JPanel();
		picture.setLayout(null);
		name = new JLabel("姓名");
		num = new JLabel("员工编号");
		photo = new JLabel("hhh");

		init();

		this.setBackground(new Color(248, 147, 69));
		for (int i = 0; i < 3; i++) {
			this.add(jb[i]);
		}
		this.add(logout);
		this.add(close);
		picture.add(name);
		picture.add(num);
		picture.add(photo);
		this.add(picture);
	}

	private void init() {
		for (int i = 0; i < 3; i++) {
			jb[i] = new JButton();
			jb[i].setBounds(0, frameHeight / 3 + frameHeight / 15 * i,
					frameWidth / 4, frameHeight / 15);
			jb[i].addActionListener(this);
		}
		jb[0].setText("填写到达单");
		jb[1].setText("填写中转单");
		jb[2].setText("填写装车单");

		logout.setMargin(new Insets(0, 0, 0, 0));
		logout.setBounds(20, frameHeight - 100, 80, 30);
		close.setMargin(new Insets(0, 0, 0, 0));
		close.setBounds(frameWidth / 4 - 100, frameHeight - 100, 80, 30);

		picture.setBounds(0, 0, frameWidth / 4, frameHeight / 3);
		name.setBounds(10, frameHeight / 3 - 50, 75, 25);
		num.setBounds(10, frameHeight / 3 - 25, 75, 25);
		photo.setBounds(frameWidth / 40, frameWidth / 40, frameWidth / 5,
				frameWidth / 5);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb[0]) {

		} else if (e.getSource() == jb[1]) {

		} else if (e.getSource() == jb[2]) {

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
