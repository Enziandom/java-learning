<%@ page contentType="text/html; charset=gb2312" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html charset=gb2312">
  <title>��ҳ</title>
</head>
<body>
<form action="register.do" method="post">
  <label>
    �û�����
    <input type="text" name="username"/>
  </label><br>
  <label>
    ���룺
    <input type="password" name="password"/>
  </label><br>
  <label>
    �Ա�
    <input type="radio" name="sex" value="male"/>��
    <input type="radio" name="sex" value="famle"/>Ů
  </label><br>
  <label>
    ���䣺<input type="text" name="age">
  </label><br>
  <label>
    ��Ȥ��<input type="checkbox" name="hobby" value="read">��ѧ
    <input type="checkbox" name="hobby" value="sport">����
    <input type="checkbox" name="hobby" value="computer">����
  </label><br>
  <label>
    ѧ����
    <select name="education">
      <option value="bachelor">ѧʿ</option>
      <option value="master">˶ʿ</option>
      <option value="doctor">��ʿ</option>
    </select>
  </label><br>
  <label>
    �����ַ��<input type="text" name="email" size="20">
  </label><br>
  <label>
    ������<textarea name="resume" rows="5" cols="30"></textarea>
  </label><br>
  <input type="submit" name="submit" value="�ύ">
  <input type="reset" name="reset" value="����">
</form>
</body>
</html>
