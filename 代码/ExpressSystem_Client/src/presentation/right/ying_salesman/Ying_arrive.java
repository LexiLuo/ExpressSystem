package presentation.right.ying_salesman;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.right.RightAll;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;


public class Ying_arrive extends RightAll implements  ActionListener{

	int frameWidth;
	int frameHeight;
	JLabel jl[];
	JButton confirm;
	JButton cancel;
	
	private List<Watcher> list;

	public Ying_arrive(int frameWidth, int frameHeight) {
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;
		
		list=new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[5];
		for (int i = 0; i < 5; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton("确认");
		cancel = new JButton("取消");

		init();

		for (int i = 0; i < 5; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		this.add(cancel);
	}

	private void init() {
		jl[0].setText("货物到达单");
		jl[1].setText("到达日期");
		jl[2].setText("中转单编号");
		jl[3].setText("出发地");
		jl[4].setText("货物到达状态");

		jl[0].setBounds(frameWidth / 2, frameHeight / 10, 100, 65);
		for (int i = 1; i < 5; i++) {
			jl[i].setBounds(frameWidth / 9, frameHeight / 15 + frameHeight / 8
					* i, 100, 65);
		}

		confirm.setBounds(frameWidth / 6, frameHeight * 9 / 10, 80, 30);
		cancel.setBounds(frameWidth * 2 / 5, frameHeight * 9 / 10, 80, 30);
		cancel.addActionListener(this);
	}

	public void addWatcher(Watcher watcher) {
		 list.add(watcher);
	}

	public void removeWatcehr(Watcher watcher) {
	 list.remove(watcher);
	}

	public void notifyWatchers(State state) {
	 for(Watcher watcher:list){
		 watcher.update(state);
	 }
	}

	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==cancel){
			 this.notifyWatchers(State.YING_START);
		 }
	}
}
