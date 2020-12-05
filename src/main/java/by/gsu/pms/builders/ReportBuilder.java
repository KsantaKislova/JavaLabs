package by.gsu.pms.builders;

import by.gsu.pms.repos.RegistrationRepo;

import java.util.stream.Collectors;

public class ReportBuilder {

    private StringBuffer report;
    private RegistrationRepo repo;

    public ReportBuilder(RegistrationRepo repo) {
        this.repo = repo;
        this.report = new StringBuffer("");
    }

    public ReportBuilder withDates() {
        this.report.append("\n" + repo.findAll().stream().map((t) -> t.getDate() + ", ").collect(Collectors.joining()));
        return this;
    }

    public ReportBuilder withNames() {
        this.report.append("\n" + repo.findAll().stream().map((t) -> t.getName() + ", ").collect(Collectors.joining()));
        return this;
    }

    public ReportBuilder withPassport() {
        this.report.append("\n" + repo.findAll().stream().map((t) -> t.getPassportNumber() + ", ").collect(Collectors.joining()));
        return this;
    }

    public ReportBuilder withClass() {
        this.report.append("\n" + repo.findAll().stream().map((t) -> t.getFlightClass() + ", ").collect(Collectors.joining()));
        return this;
    }

    public String buildReportString() {
        return this.report.toString();
    }
}
