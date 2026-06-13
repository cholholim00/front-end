package FileUpload;

import java.util.ArrayList;
import java.util.List;

import common.DBConnPool;

public class MyFileDAO extends DBConnPool {
	public int inserFile(MyFileDTO dto) {
		int applyResult = 0;
		try {
			String query = "INSERT INTO myfile(idx, name, title, cate, ofile, sfile) VALUES ";
			query += "(seq_board_num.nextval, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getCate());
			pstmt.setString(4, dto.getOfile());
			pstmt.setString(5, dto.getSfile());
			applyResult = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("Exception[insertFile]: " + e.getMessage());
		}
		return applyResult;
	}
	public List<MyFileDTO> myFileList(){
		List<MyFileDTO> list = new ArrayList<MyFileDTO>();
		try {
			String query = "SELECT * FROM myfile ORDER BY idx DESC";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MyFileDTO dto = new MyFileDTO();
				dto.setIdx(String.valueOf(rs.getInt("idx")));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getNString("title"));
				dto.setCate(rs.getString("cate"));
				dto.setOfile(rs.getString("ofile"));
				dto.setSfile(rs.getString("sfile"));
				dto.setPostdate(rs.getString("postdate"));
				list.add(dto);
			}
		}catch(Exception e) {
			System.out.println("Exception[myFileList]: " + e.getMessage());
		}
		return list;
	}
}










