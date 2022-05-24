import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class empDAO {
   private Statement stmt;
   private Connection conn;
   
   public ArrayList<empVO> listMember() {
      ArrayList<empVO> list = new ArrayList<empVO>();
      try {
         connDB(); // �װ�
         String query ="select a.employee_id,a.emp_name,b.emp_name manager_name,c.department_name "+
                    " from employees a,employees b, departments c "+
                    " where a.manager_id=b.employee_id "+
                    " and a.department_id=c.department_id"; // �Ұ� �����ְ�
         this.stmt = conn.createStatement(); //db ���� ��������
         ResultSet rs = stmt.executeQuery(query); //�Ұ� ���ְ�
         while (rs.next()) { //ģ�� ���� �����ְ�
            int eid = rs.getInt("employee_id");
            String emp_name = rs.getString("emp_name");
            String m_name = rs.getString("manager_name");
            String d_name = rs.getString("department_name");
            empVO evo = new empVO();
            evo.setEmployee_id(eid);
            evo.setEmp_name(emp_name);
            evo.setManager_name(m_name);
            evo.setDepartment_name(d_name);
            list.add(evo);
         }
         rs.close(); // ��� �ѵθ� ������? �׷��� �ݾ��ְ�
         stmt.close();
         conn.close();
         
      } catch (Exception e) {
         e.printStackTrace(); // �����ɸ��� ǥ�����ְ�
      }
      return list; //list ��ȯ���ְ�
   }
   
   private void connDB() { //db Ű�°�
      String driver="oracle.jdbc.driver.OracleDriver"; //ojdbc6
      String url ="jdbc:oracle:thin:@localhost:1521:orcl";
      String userid="ora_user";
      String passcode="human123";
      try {
         Class.forName(driver);
         this.conn = DriverManager.getConnection(url,userid,passcode);
         if(conn==null) {
            System.out.println("�����ͺ��̽� ���ӽ���");
         }
      }catch (Exception e) {
         e.printStackTrace();
      }
   }
}