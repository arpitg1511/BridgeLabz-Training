// Interface with default method
interface ReportExporter {

     void exportToCSV(String data);
     void exportToPDF(String data);

    // New feature added later without breaking old code
    default void exportToJSON(String data) {
        System.out.println("Exporting to JSON (default)");
        System.out.println("{ \"report\": \"" + data + "\" }");
    }
}

public class ReportExport {


    // Existing CSV exporter (unchanged)
    static class CsvReportExporter implements ReportExporter {

        @Override
        public void exportToCSV(String data) {
            System.out.println("CSV Export: " + data);
        }

        @Override
        public void exportToPDF(String data) {
            System.out.println("CSV exporter creating PDF: " + data);
        }
    }

    // Existing PDF exporter (unchanged)
    static class PdfReportExporter implements ReportExporter {

        @Override
        public void exportToCSV(String data) {
            System.out.println("PDF exporter creating CSV: " + data);
        }

        @Override
        public void exportToPDF(String data) {
            System.out.println("PDF Export: " + data);
        }
    }

    // Main method
    public static void main(String[] args) {

        ReportExporter csvExporter = new CsvReportExporter();
        ReportExporter pdfExporter = new PdfReportExporter();

        csvExporter.exportToCSV("Sales Report");
        csvExporter.exportToJSON("Sales Report");

        pdfExporter.exportToPDF("Inventory Report");
        pdfExporter.exportToJSON("Inventory Report");
    }
}
