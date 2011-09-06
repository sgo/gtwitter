<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <link rel="stylesheet/less" type="text/css" href="${resource(dir:'lib', file:'bootstrap.less')}">
        <script src="${resource(dir:'js', file:'less-1.1.3.min.js')}" type="text/javascript"></script>
        <g:layoutHead />
        <g:javascript library="application" />
    </head>
    <body>
        <div id="spinner" class="spinner" style="display:none;">
            <img src="${resource(dir:'images',file:'spinner.gif')}" alt="${message(code:'spinner.alt',default:'Loading...')}" />
        </div>
        <div class="topbar">
            <div class="topbar-inner">
                <div class="container">
                    <h3>${message(code:'appname', default:'gTwitter')}</h3>
                    <ul class="nav">
                        <li class=""><g:link controller="bird" action="create">${message(code:'register', default:'register')}</g:link></li>
                        <li><g:link controller="bird" action="signin">${message(code:'signin', default:'sign in')}</g:link></li>
                        <li><g:link controller="bird" action="signout">${message(code:'signout', default:'sign out')}</g:link></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="container" style="padding-top: 100px;"><g:layoutBody /></div>
    </body>
</html>