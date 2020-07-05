<div style="color: rebeccapurple">
	<h2>Freemarker 模板邮件</h2>
</div>
<hr>
<div style="color: green">
	<h4>邮件信息：</h4>
	<table border="1" style="color: darkgoldenrod">
		<thead>
			<tr>
				<th>name</th>
				<th>content</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${name}</td>
				<td>${content}</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td>just table foot</td>
				<td>nothing else</td>
			</tr>
		</tfoot>
	</table>
</div>
<hr>
<div style="color: crimson">
	<h4>注册邮箱：</h4>
	<form action="">
		<label for="name">请输入用户名：</label>
		<input type="text" id="name" placeholder="用户名"><br>
		<label for="password">请输入密码：</label>
		<input type="password" id="password" placeholder="密码"><br>
		<input type="submit" value="提交"/>
	</form>
</div>
