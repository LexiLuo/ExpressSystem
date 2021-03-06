package presentation.right.manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import businesslogicservice.constantblservice.CityServer;
import businesslogicservice.informationblservice.InstitutionInform.Inform_HallInformServer;
import businesslogicservice.informationblservice.InstitutionInform.Inform_StorageInformServer;
import businesslogicservice.informationblservice.InstitutionInform.Inform_TranStationInformServer;
import po.CityPO;
import po.SystemUserPO;
import po.Institution.HallPO;
import po.Institution.StoragePO;
import po.Institution.TranStationPO;
import po.Workers.HallStaffPO;
import po.Workers.StorageKeeperPO;
import po.Workers.TranStaffPO;
import presentation.right.ColorRenderer;
import presentation.right.RightAll;
import presentation.watcher.*;
import businesslogicservice.systemblservice.*;
import businesslogic.constantbl.CityServerImpl;
import businesslogic.informationbl.Inform_HallInformServerImpl;
import businesslogic.informationbl.Inform_StorageInformServerImpl;
import businesslogic.informationbl.Inform_TranStationInformServerImpl;
import businesslogic.systembl.SystemBlServerImpl;

public class Manager_Manage extends RightAll {
	
	CityServer cityServer;

	int frameWidth;
	int frameHeight;
	cityPanel city;
	String currentCity = null;
	String currentID = null;
	String currentOrg = null;

	private List<Watcher> list;

	Inform_TranStationInformServer tranServer;
	Inform_StorageInformServer storageServer;
	Inform_HallInformServer hallServer;

	systemServer systemServer;

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\系统管理startRight.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth * 3 / 4, frameHeight, null);
	}

	public Manager_Manage(int frameWidth, int frameHeight) {
		cityServer=new CityServerImpl();
		
		tranServer = new Inform_TranStationInformServerImpl();
		storageServer = new Inform_StorageInformServerImpl();
		hallServer = new Inform_HallInformServerImpl();
		systemServer = new SystemBlServerImpl();

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		city = new cityPanel();
		this.add(city);
	}

	class cityPanel extends JPanel implements ActionListener {
 
		DefaultTableModel model_city;
		JTable table_city;
		JScrollPane js_city;

		JButton addCity;
		JTextField jtf;
		JLabel addLabel;
		JButton overButton;

		DefaultTableCellRenderer dtc;
 
		Vector<JButton> vecButton;

		OrgPanel org = null;
		int numCity = 4;

		public cityPanel() {
			this.setLayout(null);
			this.setBounds(0, 0, frameWidth / 4, frameHeight);
			this.setBackground(Color.gray);
 
			model_city = new DefaultTableModel();
			table_city = new JTable(model_city) {
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			js_city = new JScrollPane(table_city);

			addCity = new JButton("");//增加城市
			vecButton = new Vector<JButton>();

			dtc = new ColorRenderer();

			initCityPanel();

			this.add(addCity);
			this.add(js_city);
		}

		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			ImageIcon background = new ImageIcon("pictures\\三分之一左right.png");
			Image bg = background.getImage();
			g.drawImage(bg, 0, 0, frameWidth * 1/ 4, frameHeight, null);
		}

		private void initCityPanel() {
	 
			addCity.setBounds(frameWidth / 16, frameHeight / 10 * 9,
					frameWidth / 9, frameHeight / 20);
			addCity.addActionListener(this);
			
			ImageIcon icon4 = new ImageIcon("pictures//增加城市.png");
			Image temp4 = icon4.getImage().getScaledInstance(icon4.getIconWidth(),
					icon4.getIconHeight(), icon4.getImage().SCALE_DEFAULT);
			icon4 = new ImageIcon(temp4);
			addCity.setIcon(icon4);
			
			initModel();
			js_city.setBounds(0, frameHeight / 4, frameWidth / 4,
					frameHeight / 4);
			table_city.getTableHeader().setReorderingAllowed(false);
			table_city.getTableHeader().setResizingAllowed(false);
			table_city.getColumnModel().getColumn(0).setCellRenderer(dtc);
			table_city.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent arg0) {

				}

				@Override
				public void mousePressed(MouseEvent arg0) {

				}

				@Override
				public void mouseExited(MouseEvent arg0) {

				}

				@Override
				public void mouseEntered(MouseEvent arg0) {

				}

				@Override
				public void mouseClicked(MouseEvent e) {

					int rowSelected = table_city.getSelectedRow();
					if (rowSelected >= 0) {
						currentCity = table_city.getValueAt(rowSelected, 0)
								.toString();

						System.out.println(currentCity);

						if (org != null) {
							Manager_Manage.this.remove(org);
							if (org.conOrgPanel != null) {
								Manager_Manage.this.remove(org.conOrgPanel);
							}
						}

						org = new OrgPanel();

						Manager_Manage.this.add(org);
						Manager_Manage.this.repaint();
					}

				}
			});
 
		}

		
		//根据逻辑层的城市数据初始化
		private void initModel() {
			model_city.addColumn("请选择城市");

			//注意城市名称，原有四个城市用中文，逻辑层做修改
			Iterator<CityPO> list=cityServer.getAll();
			
			while(list.hasNext()){
				CityPO city=list.next();
				

				Vector<String> vec1 = new Vector<>();
				vec1.add(city.getName());
			 

				model_city.addRow(vec1);
			}
			
 

		}

		@Override
		public void actionPerformed(ActionEvent e) {
		 

			if (e.getSource() == addCity) {
				numCity++;

				addPanel();

				this.repaint();
			}

		}

		private void removeAddPanel() {
			this.add(addCity);
			this.remove(jtf);
			this.remove(addLabel);
			this.remove(overButton);

			jtf = null;
			addLabel = null;
			overButton = null;
			this.repaint();
		}

		private void addPanel() {
			if (jtf == null) {
				this.repaint();
				this.jtf = new JTextField();
				this.addLabel = new JLabel("输入新城市编号及名称(空格隔开):");
				addLabel.setFont(new Font("宋体",Font.PLAIN,13));
				this.overButton = new JButton("");//完成
				
				jtf.setBounds(frameWidth / 28, frameHeight / 2 + frameHeight
						/ 4, frameWidth / 6, frameHeight / 20);
				addLabel.setBounds(frameWidth / 30, frameHeight / 2
						+ frameHeight / 5, frameWidth / 3, frameHeight / 20);
				overButton.setBounds(frameWidth / 16, frameHeight / 20 * 17-frameWidth/40,
						frameWidth / 9, frameHeight / 20);
				

				ImageIcon icon4 = new ImageIcon("pictures//完成.png");
				Image temp4 = icon4.getImage().getScaledInstance(
						icon4.getIconWidth(), icon4.getIconHeight(),
						icon4.getImage().SCALE_DEFAULT);
				icon4 = new ImageIcon(temp4);
				overButton.setIcon(icon4);
				
				overButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String input = jtf.getText();
						if (!input.equals("")) {

							String[] inputs=input.split(" ");
							
							Vector<String> vec = new Vector<>();
							vec.add(inputs[1]);
							model_city.addRow(vec);
							//逻辑层做增加，input

							cityServer.addCity(inputs[0], inputs[1]);
							removeAddPanel();
						}
					}
				});
 
				this.remove(addCity);
				this.add(jtf);
				this.add(addLabel);
				this.add(overButton);
				this.repaint();
			}
		}
	}

	class OrgPanel extends JPanel implements ActionListener {

		JTable orgTablel;
		DefaultTableModel orgTableModel;
		JScrollPane orgJs;
		JButton orgAdd;
		JButton orgDel;

		JTextField jtf;
		JLabel addLabel;
		JButton overButton;

		DefaultTableCellRenderer dtc;

		ConcretOrgPanel conOrgPanel = null;

		public OrgPanel() {

			this.setLayout(null);
			this.setBounds(frameWidth / 4, 0, frameWidth / 4, frameHeight);
			this.setBackground(Color.magenta);

			dtc = new ColorRenderer();

			initOrgPanel();

			this.add(orgJs);
			this.add(orgAdd);
			this.add(orgDel);

		}

		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			ImageIcon background = new ImageIcon("pictures\\三分之二中right.png");
			Image bg = background.getImage();
			g.drawImage(bg, 0, 0, frameWidth *1 / 4, frameHeight, null);
		}

		private void initOrgPanel() {

			initOrgTable(currentCity);
			orgTablel = new JTable(orgTableModel) {
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			TableColumn firstColumn = orgTablel.getColumnModel().getColumn(0);
			firstColumn.setPreferredWidth(frameWidth / 6);
			orgTablel.getTableHeader().setReorderingAllowed(false);
			orgTablel.getTableHeader().setResizingAllowed(false);
			orgTablel.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent arg0) {

				}

				@Override
				public void mousePressed(MouseEvent arg0) {

				}

				@Override
				public void mouseExited(MouseEvent arg0) {

				}

				@Override
				public void mouseEntered(MouseEvent arg0) {

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					String location = (String) ((JTable) e.getSource())
							.getValueAt(orgTablel.getSelectedRow(), 0);
					currentOrg = location;
					currentID = (String) ((JTable) e.getSource()).getValueAt(
							orgTablel.getSelectedRow(), 1);
					if (conOrgPanel != null) {
						Manager_Manage.this.remove(conOrgPanel);
					}
					conOrgPanel = new ConcretOrgPanel(location);
					Manager_Manage.this.add(conOrgPanel);
					Manager_Manage.this.repaint();
				}
			});
			orgTablel.setRowSelectionAllowed(true);
			orgTablel.getColumnModel().getColumn(0).setCellRenderer(dtc);
			orgTablel.getColumnModel().getColumn(1).setCellRenderer(dtc);
			orgJs = new JScrollPane(orgTablel);

			orgJs.setBounds(0, 0, frameWidth / 4, frameHeight / 2);

			orgAdd = new JButton("");//增加
			orgAdd.setBounds(frameWidth / 16,
					frameHeight / 2 + frameHeight / 8, frameWidth / 9,
					frameHeight / 20);
			orgAdd.addActionListener(this);
			orgDel = new JButton("");//删除
			orgDel.setBounds(frameWidth / 16, frameHeight / 10 * 9,
					frameWidth / 9, frameHeight / 20);
			orgDel.addActionListener(this);
			
			ImageIcon icon2 = new ImageIcon("pictures//增加黄.png");
			Image temp2 = icon2.getImage().getScaledInstance(
					icon2.getIconWidth(), icon2.getIconHeight(),
					icon2.getImage().SCALE_DEFAULT);
			icon2 = new ImageIcon(temp2);
			orgAdd.setIcon(icon2);

			ImageIcon icon3 = new ImageIcon("pictures//删除.png");
			Image temp3 = icon3.getImage().getScaledInstance(
					icon3.getIconWidth(), icon3.getIconHeight(),
					icon3.getImage().SCALE_DEFAULT);
			icon3 = new ImageIcon(temp3);
			orgDel.setIcon(icon3);



		}

		// 机构的初始化
		private void initOrgTable(String city1) {
			orgTableModel = new DefaultTableModel();
			orgTableModel.addColumn("机构");
			orgTableModel.addColumn("编号");
			Vector<String> vec;
			Iterator it;

			if ((it = tranServer.getByLocation(city1)) != null) {
				while (it.hasNext()) {
					vec = new Vector<String>();
					TranStationPO station = (TranStationPO) it.next();
					vec.add(station.getName());
					vec.add(station.getID());
					orgTableModel.addRow(vec);
				}
			}

			if ((it = storageServer.getByLocation(city1)) != null) {
				while (it.hasNext()) {
					vec = new Vector<String>();
					StoragePO storage = (StoragePO) it.next();
					vec.add(storage.getName());
					vec.add(storage.getID());
					orgTableModel.addRow(vec);
				}
			}

			if ((it = hallServer.getByLocation(city1)) != null) {
				while (it.hasNext()) {
					vec = new Vector<String>();
					HallPO hall = (HallPO) it.next();
					vec.add(hall.getName());
					vec.add(hall.getID());
					orgTableModel.addRow(vec);
				}
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == orgAdd) {
				addPanel();
			} else if (e.getSource() == orgDel) {

				int row = orgTablel.getSelectedRow();
				if (row >= 2) {
					String id = (String) orgTablel.getValueAt(row, 1);
					System.out.println("delete!");

					hallServer.removeHall(id);
					orgTableModel.removeRow(row);
				}
				// 逻辑层删除

			}
		}

		private void addPanel() {
			if (jtf == null) {
				this.repaint();
				this.jtf = new JTextField();
				this.addLabel = new JLabel("请输入机构名称:");
				this.overButton = new JButton("");//完成
				jtf.setBounds(frameWidth / 24, frameHeight / 2 + frameHeight
						/ 4, frameWidth / 6, frameHeight / 20);
				addLabel.setBounds(frameWidth / 24, frameHeight / 2
						+ frameHeight / 5, frameWidth / 6, frameHeight / 20);
				overButton.setBounds(frameWidth / 16, frameHeight / 20 * 17-frameWidth/40,
						frameWidth / 9, frameHeight / 20);
				
               addLabel.setFont(new Font("宋体",Font.PLAIN,13));
				ImageIcon icon4 = new ImageIcon("pictures//完成.png");
				Image temp4 = icon4.getImage().getScaledInstance(
						icon4.getIconWidth(), icon4.getIconHeight(),
						icon4.getImage().SCALE_DEFAULT);
				icon4 = new ImageIcon(temp4);
				overButton.setIcon(icon4);
				
				overButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String input = jtf.getText();
						if (!input.equals("")) {

							// listModel.addElement(input);
							HallPO hall = hallServer
									.addHall(currentCity, input);
							Vector vec = new Vector();
							vec.add(input);
							vec.add(hall.getID());
							orgTableModel.addRow(vec);

							removeAddPanel();
						}
					}
				});

				this.add(jtf);
				this.add(addLabel);
				this.add(overButton);
				this.repaint();
			}
		}

		private void removeAddPanel() {
			this.remove(jtf);
			this.remove(addLabel);
			this.remove(overButton);

			jtf = null;
			addLabel = null;
			overButton = null;
			this.repaint();
		}

	}

	class ConcretOrgPanel extends JPanel implements ActionListener {

		DefaultTableModel con_tableModel;
		JTable con_table;
		JScrollPane con_js;

		JTextField jtf;
		JLabel addLabel;
		JButton overButton;
		JButton con_orgAdd;
		JButton con_orgDel;

		DefaultTableCellRenderer dtc;
		String currentOrg;

		public ConcretOrgPanel(String currentOrg) {
			this.setLayout(null);
			this.setBounds(frameWidth / 2, 0, frameWidth / 4, frameHeight);
			this.setBackground(Color.lightGray);

			this.currentOrg = currentOrg;

			dtc = new ColorRenderer();

			initConcretOrgPanel();

			this.add(con_js);
			this.add(con_orgAdd);
			this.add(con_orgDel);
		}

		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			ImageIcon background = new ImageIcon("pictures\\三分之一right.png");
			Image bg = background.getImage();
			g.drawImage(bg, 0, 0, frameWidth * 1/ 4, frameHeight, null);
		}

		private void initConcretOrgPanel() {
			con_tableModel = new DefaultTableModel();
			con_table = new JTable(con_tableModel) {
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			con_table.setRowSelectionAllowed(true);
			con_table.setEditingRow(-1);
			initTableModel();
			con_js = new JScrollPane(con_table);
			con_js.setBounds(0, 0, frameWidth / 4, frameHeight / 2);

			con_orgAdd = new JButton("");//增加
			con_orgAdd.setBounds(frameWidth / 16, frameHeight / 2 + frameHeight
					/ 8, frameWidth / 9, frameHeight / 20);
			con_orgAdd.addActionListener(this);
			con_orgDel = new JButton("");//删除
			con_orgDel.setBounds(frameWidth / 16, frameHeight / 10 * 9,
					frameWidth / 9, frameHeight / 20);
			con_orgDel.addActionListener(this);
			
			ImageIcon icon2 = new ImageIcon("pictures//增加黄.png");
			Image temp2 = icon2.getImage().getScaledInstance(
					icon2.getIconWidth(), icon2.getIconHeight(),
					icon2.getImage().SCALE_DEFAULT);
			icon2 = new ImageIcon(temp2);
			con_orgAdd.setIcon(icon2);

			ImageIcon icon3 = new ImageIcon("pictures//删除.png");
			Image temp3 = icon3.getImage().getScaledInstance(
					icon3.getIconWidth(), icon3.getIconHeight(),
					icon3.getImage().SCALE_DEFAULT);
			icon3 = new ImageIcon(temp3);
			con_orgDel.setIcon(icon3);


		}

		// 人员的初始化
		private void initTableModel() {
			con_tableModel.addColumn("姓名");
			con_tableModel.addColumn("编号");

			con_table.getColumnModel().getColumn(0).setCellRenderer(dtc);
			con_table.getColumnModel().getColumn(1).setCellRenderer(dtc);

			// 根据currentOrg判断初始化信息，并加入

			if (currentOrg.contains("仓库")) {
				Iterator<StorageKeeperPO> it = storageServer
						.getAllKeeper(currentID);
				while (it.hasNext()) {
					StorageKeeperPO keeper = it.next();
					Vector vec = new Vector<>();

					vec.add(keeper.getName());
					vec.add(keeper.getID());

					con_tableModel.addRow(vec);

				}
			} else if (currentOrg.contains("中转中心")) {
				Iterator<TranStaffPO> it = tranServer.getAllStaff(currentID);
				while (it.hasNext()) {
					TranStaffPO staff = it.next();
					Vector vec = new Vector<>();

					vec.add(staff.getName());
					vec.add(staff.getId());

					con_tableModel.addRow(vec);

				}
			} else {
				Iterator<HallStaffPO> it = hallServer.getAllStaff(currentID);
				while (it.hasNext()) {
					HallStaffPO staff = it.next();
					Vector vec = new Vector<>();

					vec.add(staff.getName());
					vec.add(staff.getId());

					con_tableModel.addRow(vec);

				}
			}

		}

		private void addPanel() {
			if (jtf == null) {
				this.repaint();
				this.jtf = new JTextField();
				this.addLabel = new JLabel("请输入员工编号:");
				this.overButton = new JButton("");//完成
				jtf.setBounds(frameWidth / 24, frameHeight / 2 + frameHeight
						/ 4, frameWidth / 6, frameHeight / 20);
				addLabel.setBounds(frameWidth / 24, frameHeight / 2
						+ frameHeight / 5, frameWidth / 6, frameHeight / 20);
				overButton.setBounds(frameWidth / 16, frameHeight / 20 * 17-frameWidth/40,
						frameWidth / 9, frameHeight / 20);
				
				ImageIcon icon4 = new ImageIcon("pictures//完成.png");
				Image temp4 = icon4.getImage().getScaledInstance(
						icon4.getIconWidth(), icon4.getIconHeight(),
						icon4.getImage().SCALE_DEFAULT);
				icon4 = new ImageIcon(temp4);
				overButton.setIcon(icon4);
				
				overButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String input = jtf.getText();
						Vector<String> vec = new Vector<String>();

						// 向量的第一维根据由input根据逻辑层得到员工姓名

						SystemUserPO user = systemServer.inquire(input);
						if (user == null)
							System.out.println("不存在该系统用户！");
						else {
							vec.add(user.getUserName());
							vec.add(input);
						}
						boolean OK;
						if (currentOrg.contains("仓库")) {
							OK = storageServer.addKeeper(currentID, input);
						} else if (currentOrg.contains("中转中心")) {
							OK = tranServer.addStaff(currentID, input);
						} else {
							OK = hallServer.addStaff(currentID, input);
						}

						if (!input.equals("") && user != null && OK) {
							con_tableModel.addRow(vec);
							removeAddPanel();
						}
					}
				});

				this.add(jtf);
				this.add(addLabel);
				this.add(overButton);
				this.repaint();
			}
		}

		private void removeAddPanel() {
			this.remove(jtf);
			this.remove(addLabel);
			this.remove(overButton);

			jtf = null;
			addLabel = null;
			overButton = null;
			this.repaint();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == con_orgAdd) {
				addPanel();
			} else if (e.getSource() == con_orgDel) {
				int row = con_table.getSelectedRow();
				String currentStaffID = (String) con_table.getValueAt(row, 1);
				boolean ok;
				if (row >= 0) {
					if (currentOrg.contains("仓库")) {
						ok = storageServer.removeKeeper(currentID,
								currentStaffID);
					} else if (currentOrg.contains("中转中心")) {
						ok = tranServer.removeStaff(currentID, currentStaffID);
					} else {
						ok = hallServer.removeStaff(currentID, currentStaffID);
						System.out.println(currentID);
						System.out.println(currentStaffID);
					}
					if (ok) {
						con_tableModel.removeRow(row);
					}

				}
			}
		}
	}

	@Override
	public void addWatcher(Watcher watcher) {
		list.add(watcher);
	}

	@Override
	public void removeWatcehr(Watcher watcher) {
		list.remove(watcher);
	}

	@Override
	public void notifyWatchers(State state) {

		for (Watcher watcher : list) {
			watcher.update(state);
		}

	}

}
