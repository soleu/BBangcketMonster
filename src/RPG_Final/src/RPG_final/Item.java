package RPG_Final.src.RPG_final;
public class Item{
String name;//��ǰ �̸�
int price;// ����
int stat;//�ɷ�
	
	Item(){}
	Item(String name,int price,int stat){
		this.name=name;
		this.price=price;
		this.stat=stat;
	}

	void printItem(){
		System.out.println("�̸� : "+name+" ���� : "+price+"��� �ɷ� : +"+stat);
	}
}
