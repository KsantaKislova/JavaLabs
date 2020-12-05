<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div style="text-align: center;">
        <p style="color: tomato">${message}</p>
        <@l.login path="/registration" mes="Register "/>

        <a style="margin-left:auto; margin-right:auto; color: hotpink; width: 5rem; font-style: normal;" href="/login">Back</a>
    </div>

</@c.page>