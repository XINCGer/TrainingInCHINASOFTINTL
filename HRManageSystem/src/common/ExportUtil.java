package common;

import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExportUtil {
	public static boolean export(String name,int rowNum){
		HSSFWorkbook wb =new HSSFWorkbook();
		HSSFSheet sheet1=wb.createSheet(name);
		SimpleDateFormat myDate=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String currentTime=myDate.format(new Date());
		FileOutputStream fos;
		ResultSet rs;
		try {
			String sql="select *from "+name;
			PreparedStatement pstmt = DataBaseUtil.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			fos=new FileOutputStream("D:\\"+name+"-"+currentTime+".xls");
			HSSFRow row1= sheet1.createRow(0);
			HSSFCell cell=null;
			switch (name) {
			case "dept":
				cell=row1.createCell(0);
				cell.setCellValue("部门编号");
				cell=row1.createCell(1);
				cell.setCellValue("部门名称");
				cell=row1.createCell(2);
				cell.setCellValue("部门地址");
				break;
			case "duty":
				cell=row1.createCell(0);
				cell.setCellValue("职务编号");
				cell=row1.createCell(1);
				cell.setCellValue("职务名称");
				cell=row1.createCell(2);
				cell.setCellValue("最低工资");
				cell=row1.createCell(3);
				cell.setCellValue("最低工资");
				break;
			case "staff":
				cell=row1.createCell(0);
				cell.setCellValue("员工编号");
				cell=row1.createCell(1);
				cell.setCellValue("员工姓名");
				cell=row1.createCell(2);
				cell.setCellValue("员工性别");
				cell=row1.createCell(3);
				cell.setCellValue("员工工资");
				cell=row1.createCell(4);
				cell.setCellValue("员工电话");
				cell=row1.createCell(5);
				cell.setCellValue("员工部门");
				cell=row1.createCell(6);
				cell.setCellValue("员工职务");
				break;

			default:
				break;
			}
			try {
				int i=1;
				while(rs.next()){
					HSSFRow row= sheet1.createRow(i);
					HSSFCell cell2=null;
					for(int j=0;j<rowNum;){
						cell2=row.createCell(j++);
						cell2.setCellValue(rs.getString(j));
					}
					i++;
				}

			} catch (SQLException e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "数据库中无数据!", "警告",
						JOptionPane.WARNING_MESSAGE);
			}
			wb.write(fos);
			fos.close();

			return true;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return false;
	}
}
