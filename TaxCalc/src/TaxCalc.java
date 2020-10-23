import java.util.*;

public class TaxCalc {
	private double income = 0;
	// double arr[]= {0,105,555,1005,2775,5505,13505};
	private double overIncome;
	private double tax = 0;
	private double afterTaxCalc;
	static Scanner in = new Scanner(System.in);

	// ���ʡ�н�����ã�
	void salaryTaxCalc() {
		while (income >= 0) {
			System.out.println();
			System.out.println("please input your salary income!");
			System.out.println("And input the sum of your 3 ensurance & 1 fund!");
			try {
				double income1 = in.nextDouble();
				double e_f = in.nextDouble();
				if (e_f >= 0) {
					income = income1 - e_f;
				} else {
					System.out.println("��������������ѡ�����룡");
					break;
				}
			} catch (Exception e) {
				in.nextLine();
				System.out.println("��������Ƿ��ַ���");
				break;
			}
			if (income < 0) {
				System.out.println("�����˳�.");
				break;
			}
			overIncome = income - 3500;
			if (overIncome <= 0) {
				tax = 0;
			} else if (overIncome > 0 && overIncome <= 1500) {
				tax = overIncome * 0.03;
			} else if (overIncome <= 4500 && overIncome > 1500) {
				tax = overIncome * 0.1 - 105;
			} else if (overIncome <= 9000 && overIncome > 4500) {
				tax = overIncome * 0.2 - 555;
			} else if (overIncome <= 35000 && overIncome > 9000) {
				tax = overIncome * 0.25 - 1005;
			} else if (overIncome <= 55000 && overIncome > 35000) {
				tax = overIncome * 0.3 - 2775;
			} else if (overIncome <= 80000 && overIncome > 55000) {
				tax = overIncome * 0.35 - 5505;
			} else if (overIncome > 80000) {
				tax = overIncome * 0.45 - 13505;
			}
			afterTaxCalc = income - tax;
			System.out.println("Ӧ��˰��:" + String.format("%.2f", tax));
			System.out.println("˰������:" + String.format("%.2f", afterTaxCalc));
		}
	}

	// ���幤�̻�����������Ӫ���ü�������ҵ��λ�ĳа���Ӫ�����⾭Ӫ����
	void indiTax() {
		while (income >= 0) {
			System.out.println();
			System.out.println("please input your individual or company over income!");
			try {
				income = in.nextDouble();
			} catch (Exception e) {
				in.nextLine();
				System.out.println("��������Ƿ��ַ���");
				break;
			}
			if (income < 0) {
				System.out.println("�����˳�.");
				break;
			} else if (income <= 15000 && income >= 0) {
				tax = income * 0.05;
			} else if (income > 15000 && income <= 30000) {
				tax = income * 0.1 - 750;
			} else if (income > 30000 && income <= 60000) {
				tax = income * 0.2 - 3750;
			} else if (income > 60000 && income <= 100000) {
				tax = income * 0.3 - 9750;
			} else if (income > 100000) {
				tax = income * 0.35 - 14750;
			}

			afterTaxCalc = income - tax;
			System.out.println("Ӧ��˰��:" + String.format("%.2f", tax));
			System.out.println("˰������:" + String.format("%.2f", afterTaxCalc));
		}
	}

	// ����Ȩʹ�÷����á��Ʋ���������
	void workTax() {
		while (income >= 0) {
			System.out.println();
			System.out.println("please input your work income!");
			try {
				income = in.nextDouble();
			} catch (Exception e) {
				in.nextLine();
				System.out.println("��������Ƿ��ַ���");
				break;
			}
			if (income < 0) {
				System.out.println("�����˳�.");
				break;
			} else if(income<=800) {
				tax=0;
			} else if (income <= 4000 && income >800) {
				tax = (income - 800) * 0.2;
			} else if (income > 4000) {
				tax = income * 0.8 * 0.2;
			}
			afterTaxCalc = income - tax;
			System.out.println("Ӧ��˰��:" + String.format("%.2f", tax));
			System.out.println("˰������:" + String.format("%.2f", afterTaxCalc));
		}
	}

	// �������
	void remuTax() {
		while (income >= 0) {
			System.out.println();
			System.out.println("please input your remuneration income!");
			try {
				income = in.nextDouble();
			} catch (Exception e) {
				in.nextLine();
				System.out.println("��������Ƿ��ַ���");
				break;
			}
			if (income < 0) {
				System.out.println("�����˳�.");
				break;
			} else if (income <= 800) {
				tax = 0;
			} else if (income <= 4000 && income > 800) {
				tax = (income - 800) * 0.2 * 0.7;
			} else if (income > 4000) {
				tax = income * 0.8 * 0.2 * 0.7;
			}
			afterTaxCalc = income - tax;
			System.out.println("Ӧ��˰��:" + String.format("%.2f", tax));
			System.out.println("˰������:" + String.format("%.2f", afterTaxCalc));
		}
	}

	// ���񱨳�����
	void doingTax() {
		while (income >= 0) {
			System.out.println();
			System.out.println("please input your other income!");
			try {
				income = in.nextDouble();
			} catch (Exception e) {
				in.nextLine();
				System.out.println("��������Ƿ��ַ���");
				break;
			}
			if (income < 0) {
				System.out.println("�����˳�.");
				break;
			} else if (income <= 800) {
				tax = 0;
			} else if (income <= 4000 && income > 800) {
				tax = (income - 800) * 0.2;
			} else if (income > 4000) {
				double overIncome = income * 0.8;
				if (overIncome <= 20000) {
					tax = overIncome * 0.2;
				} else if (overIncome > 20000 && overIncome <= 50000) {
					tax = overIncome * 0.3 - 2000;
				} else if (overIncome > 50000) {
					tax = overIncome * 0.4 - 7000;
				}
			}
			afterTaxCalc = income - tax;
			System.out.println("Ӧ��˰��:" + String.format("%.2f", tax));
			System.out.println("˰������:" + String.format("%.2f", afterTaxCalc));
		}
	}

	// ��Ϣ����Ϣ���������á��Ʋ�ת�����á�żȻ����
	void otherTax() {
		while (income >= 0) {
			System.out.println();
			System.out.println("please input your other income!");
			try {
				income = in.nextDouble();
			} catch (Exception e) {
				in.nextLine();
				System.out.println("��������Ƿ��ַ���");
				break;
			}
			if (income < 0) {
				System.out.println("�����˳���");
				break;
			}
			tax = income * 0.2;
			afterTaxCalc = income - tax;
			System.out.println("Ӧ��˰��:" + String.format("%.2f", tax));
			System.out.println("˰������:" + String.format("%.2f", afterTaxCalc));
		}
	}

	public static void main(String args[]) {
		for (;;) {
			System.out.println("��ѡ����������(0-9):");
			System.out.println("   ���         ����");
			System.out.println("  0  |���ʡ�н������");
			System.out.println("  1  |���幤�̻�����������Ӫ����");
			System.out.println("  2  |������ҵ��λ�ĳа���Ӫ�����⾭Ӫ����");
			System.out.println("  3  |���񱨳�����");
			System.out.println("  4  |�������");
			System.out.println("  5  |����Ȩʹ�÷�����");
			System.out.println("  6  |��Ϣ����Ϣ����������");
			System.out.println("  7  |�Ʋ���������");
			System.out.println("  8  |�Ʋ�ת������");
			System.out.println("  9  |żȻ����");
			System.out.println("--------------------------------");
			System.out.println("��ܰ��ʾ������10�� �˳�ϵͳ");
			int key = 0;
			try {
				key = in.nextInt();
			} catch (Exception e) {
				System.out.println("�Ƿ��ַ��������˳���");
				break;
			}
			TaxCalc taxCalc = new TaxCalc();
			switch (key) {
			case 0:
				taxCalc.salaryTaxCalc();
				break;
			case 1:
			case 2:
				taxCalc.indiTax();
				break;
			case 3:
				taxCalc.doingTax();
				break;
			case 4:
				taxCalc.remuTax();
				break;
			case 5:
			case 7:
				taxCalc.workTax();
				break;
			case 6:
			case 8:
			case 9:
				taxCalc.otherTax();
				break;
			case 10:
				System.out.println("�����˳�ϵͳ��");
				System.exit(0);
			}
		}
	}

}
