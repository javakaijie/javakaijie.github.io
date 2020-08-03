<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户列表</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>

    <style type="text/css">
        .box {
            width: 800px;
            margin: 50px auto;
            border: 1px solid #DCDFE6;
            border-radius: 20px;
            padding: 20px;
        }

        .box:hover {
            box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
        }

        .box-title {
            text-align: center;
        }

        .box-table {
            margin-top: 20px;
        }
        .box-nav{
            text-align: center;
        }
    </style>
</head>
<body>
<div class="box">
    <h3 class="box-title">用户信息列表</h3>
    <form class="form-inline" style="width: 100%" action="/findByCondition" method="post">
        <div class="form-group">
            <label for="name">姓名</label>
            <input type="text" class="form-control" id="name" placeholder="请输入用户名称" name="name">
        </div>
        <button type="submit" class="btn btn-default">查询</button>
        <a href="/edit" style="float: right">
            增加
        </a>
    </form>
    <table class="table table-bordered box-table">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pageInfo.list}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.email}</td>
                <td>
                    <a href="/edit?id=${user.id}">
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                    </a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/del?id=${user.id}">
                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div class="box-nav">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pageInfo.hasPreviousPage}">
                    <li>
                        <a href="/users?pageNum=${pageInfo.pageNum-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach begin="1" end="${pageInfo.pages}" var="i">
                    <li><a href="/users?pageNum=${i}">${i}</a></li>
                </c:forEach>
                <c:if test="${pageInfo.hasNextPage}">
                    <li>
                        <a href="/users?pageNum=${pageInfo.pageNum+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
            </ul>
        </nav>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
