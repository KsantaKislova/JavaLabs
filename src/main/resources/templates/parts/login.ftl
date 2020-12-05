<#macro login path mes>
    <form style="display:block; margin-left:auto; margin-top: 5rem; margin-bottom: 1rem; margin-right:auto; width:14rem; position: center; background-color: darkcyan; color: aliceblue; border-style: solid; padding: 3rem; border-radius: 0.5rem;" action="${path}" method="post">
        <div><label>User name : <input type="text" name="username"/></label></div>
        <br/>
        <div><label>Password : <input type="password" name="password"/></label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <br/>
        <div style="position: center;"><input type="submit" value=${mes}/></div>
    </form>
</#macro>
<#macro logout>
    <div style="float: right; float: top; margin-right: 2.5rem; margin-top: 0.5rem">
        <form action="/logout" method="post">
            <input type="submit" value="Sign out">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
        </form>
    </div>
</#macro>