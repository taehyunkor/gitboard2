package co.kr.git.domain;

import java.util.Date;

public class PortfolioBoard {
	private int num;
	private String email;
	private String title;
	private String content;
	// 날짜를 비교해서 시간과 날짜를 구분해서 출력하려면
	// 시간을 같이 저장해야 하는데 util.Date는 시간을 가지고
	// 있지만 sql.Date은 날짜만 저장하기 때문에
	// util.Date를 사용해야 합니다.
	private Date writedate;
	private int readcnt;
	private String ip;
	// 글쓴 날짜와 시간을 구분해서 출력해야 하기때문에
	// 날짜와 시간을 출력할 때 사용할 변수
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Override
	public String toString() {
		return "PortfolioBoard [num=" + num + ", email=" + email + ", title=" + title + ", content=" + content
				+ ", writedate=" + writedate + ", readcnt=" + readcnt + ", ip=" + ip + "]";
	}
	
	
	
}
