<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <title>${bird}</title>
      <meta name="layout" content="main" />
  </head>
  <body>
    <h1>${bird}</h1>
    <table class="zebra-striped">
        <tbody>
            <g:each in="${tweets}" var="tweet">
                <tr>
                    <td class="msg">${tweet.msg}</td>
                    <td class="datetime"><g:formatDate date="${tweet.millis}" format="yyyy-MM-dd HH:mm:ss:SSS"/></td>
                </tr>
            </g:each>
        </tbody>
    </table>
    <g:form action="tweet">
        <div class="input"><textarea class="xxlarge" name="msg"></textarea></div>
        <div class="actions">
            <input class="btn primary" type="submit" value="${message(code:'tweet', default:'tweet')}"/>
        </div>
    </g:form>
  </body>
</html>