<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<#import "parts/shots.ftl" as s>
<@c.page>
<@l.logout/>
<div>
    <form style="margin-top:3rem; margin-bottom:2rem;padding:1rem; padding-left:2rem;border-style:solid; border-color: beige; border-radius: 1rem; background-color: darkcyan; color:aliceblue; margin-left:2rem;width: 60%" method="post">
        <button style="float:right; margin-right: 2rem" type="submit">Register</button>
        <input size="50" maxlength="40" type="text" name="name" placeholder="Enter full name" required="true"/>
        <input style="margin-left: 1rem;" type="date" name="date" placeholder="Enter date" required="true"/>
        <select style="position: center; align-content: center; float: right; margin-right: 7.3rem" name="flightClass" required="true">
            <option value="ECONOMICAL">Economical</option>
            <option value="BUSINESS">Business</option>
            <option value="PRIVATE_JET">Private Jet</option>
        </select>
        <br/>
        <input size="50" maxlength="40" type="text" name="passportNumber" placeholder="Enter passport number" required="true"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
</div>
<div style="width: 50%;margin-left: 2rem; background-color: darkcyan; border-style: solid; border-color: beige; border-radius: 1rem; padding: 1.5rem">
    <div style="color: beige">Your registration</div>
    <@s.shots/>
</div>

    <div style="position: absolute; right: 5%; top:22%; padding:1rem; padding-left:2rem;border-style:solid; border-color: beige; border-radius: 1rem; background-color: darkcyan; color:aliceblue; width: 30%">
        <b style="align-content:center; margin-left:auto; margin-right:auto;font-size: 20pt">Filter</b>
        <form action="/Home/Date" style="background-color: beige;width:13rem; height:6rem; border-radius: 1rem;" method="get">
            <input style="margin-top: 1rem; margin-left: 1.5rem" type="date" name="date"/>
            <button style="float:bottom; margin-top: 1.6rem; margin-left: 1.5rem" type="submit">Filter</button>

            <input type="hidden" name="_csrf" value="${_csrf.token}">
        </form>
        <br/>
        <form action="/Home/Urgency" style="width:13rem; height:6rem; background-color: beige; border-radius: 1rem;" method="get">
            <select style="float:top; margin-top: 1rem;margin-left: 1.5rem"  name="flightClass" required="true">
                <option value="ECONOMICAL">Economical</option>
                <option value="BUSINESS">Business</option>
                <option value="PRIVATE_JET">Private Jet</option>
            </select>
            <br/>
            <button style="float:bottom;margin-top: 1.8rem; margin-left: 1.5rem "  type="submit">Filter</button>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
        </form>
        <a style="align-content: center;" href="/Home"><button style="margin-top: 2rem;padding: 0.3rem;">Clear filter</button></a>
    </div>


    <div style="position: absolute; right: 5%; top:72%; padding:1rem; padding-left:2rem;border-style:solid; border-color: beige; border-radius: 1rem; background-color: darkcyan; color:aliceblue; width: 30%">
            <b style="align-content:center; margin-left:auto; margin-right:auto;font-size: 20pt">Report</b>
            <form action="/Home/file" contentType='text/csv;charset=utf-8' style="width:13rem; border-radius: 1rem;" method="get">

                <input type="radio" id="contactChoice1"
                 name="withClass" value="true" checked>
                <label for="contactChoice1" style="color: 'black'">with flight class</label>
                <br/>
                <input type="radio" id="contactChoice2"
                 name="withClass" value="false">
                <label for="contactChoice2" style="color: 'black'">without flight class</label>
                <br/><br/>

                <input type="radio" id="contactChoice3"
                 name="withNames" value="true" checked>
                <label for="contactChoice3" style="color: 'black'">with names</label>
                <br/>
                <input type="radio" id="contactChoice4"
                 name="withNames" value="false">
                <label for="contactChoice4" style="color: 'black'">without names</label>
                <br/><br/>

                <input type="radio" id="contactChoice5"
                 name="withDates" value="true" checked>
                <label for="contactChoice5" style="color: 'black'">with dates</label>
                <br/>
                <input type="radio" id="contactChoice6"
                 name="withDates" value="false">
                <label for="contactChoice6" style="color: 'black'">without dates</label>
                <br/><br/>

                <input type="radio" id="contactChoice7"
                 name="withPassport" value="true" checked>
                <label for="contactChoice7" style="color: 'black'">with passport</label>
                <br/>
                <input type="radio" id="contactChoice8"
                 name="withPassport" value="false">
                <label for="contactChoice8" style="color: 'black'">without passport</label>
                <br/><br/>

                <button style="float:bottom; margin-top: 1.6rem; margin-left: 1.5rem" type="submit">Get report</button>

                <input type="hidden" name="_csrf" value="${_csrf.token}">
            </form>
        </div>

</@c.page>