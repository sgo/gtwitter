<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <title>${message(code:'register', default:'register')}</title>
      <meta name="layout" content="main" />
  </head>
  <body>
    <h1>${message(code:'register', default:'register')}</h1>
    <g:form action="save">
        <label>${message(code:'name', default:'name')}</label>
        <div class="input"><input type="text" name="name"/></div>
        <div class="actions">
            <input class="btn primary" type="submit" value="${message(code:'register', default:'register')}"/>
        </div>
    </g:form>
  </body>
</html>