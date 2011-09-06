<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <title>${message(code:'signin', default:'sign in')}</title>
      <meta name="layout" content="main" />
  </head>
  <body>
    <h1>${message(code:'signin', default:'sign in')}</h1>
    <g:form action="authenticate">
        <label>${message(code:'name', default:'name')}</label>
        <div class="input"><input type="text" name="name"/></div>
        <div class="actions">
            <input class="btn primary" type="submit" value="${message(code:'signin', default:'sign in')}"/>
        </div>
    </g:form>
  </body>
</html>