<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <div style="text-align: center">

        <@l.login path="/login" mes="Enter "/>
        <#if RequestParameters.error??>
            <p style="text-align:center; margin-top: -3rem; margin-bottom: 1.8rem; color: tomato">Wrong username or password !</p>
        </#if>

        <a style="margin-left:auto; margin-right:auto; color: hotpink; width: 5rem; font-style: normal;" href="/registration">Sign up</a>
    </div>
</@c.page>