package FunctionLayer;


public class SVG {

        private int width;
        private int height;
        private String viewbox;
        private int x;
        private int y;
        private StringBuilder svg = new StringBuilder();

        private final String headerTemplate = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" height=\"%s\" width=\"%s\" viewBox=\"%s\" preserveAspectRatio=\"xMinYMin\">";
        private final String lineTemplate ="<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" style=\"stroke:#000000;stroke-width:2\" />";
        private final String arrowTemplate = "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" style=\"stroke:#000000;" +
                                            "stroke-width:2;marker-start:url(#beginArrow);marker-end:url(#endArrow);\" />";
        private final String textTemplate = "<text x=\"%d\" y=\"%d\" style=\"text-anchor: middle\" transform=\"rotate(\"%d\" \"%d\",\"%d\")\">%d cm</text>";
        private final String textRotateTemplate = "<text x=\"%d\" y=\"%d\" style=\"text-anchor: middle\" transform=\"translate(%d, %d) rotate(%d)\">%d cm</text>";
        private final String rectTemplate = "<rect x=\"%d\" y=\"%d\" height=\"%d\" width=\"%d\" style=\"stroke:#000000; fill: #ffffff\"/>";
        private final String rectTemplateRotate = "<rect x=\"%d\" y=\"%d\" height=\"%d\" width=\"%d\" transform=\"rotate(%d %d %d)\"style=\"stroke:#000000; fill: #ffffff\"/>";

    public SVG(int width, int height, String viewbox, int x, int y) {
            this.width = width;
            this.height = height;
            this.viewbox = viewbox;
            this.x = x;
            this.y = y;
            svg.append(String.format(headerTemplate, height, width, viewbox));
        }

        public void addRect(int x, int y, int height, int width){
            svg.append(String.format(rectTemplate, x, y, height, width));
        }

        public void rectTemplateRotate(int x, int y, int height, int width, int rotation, int rotX, int rotY){
            svg.append(String.format(rectTemplateRotate, x, y, height, width, rotation, rotX, rotY));
        }

        public  void addLine(int x, int y, int x2, int y2){
            svg.append(String.format(lineTemplate, x,  y,  x2, y2));
        }

        public void addText(int x1, int y1, int rotate, int wOrL) {
            svg.append(String.format(textTemplate, x1, y1, rotate, x1, y1, wOrL));
        }

        public void addTextRotate(int x1, int y1, int rotate, int wOrL) {
        String cc = "<text x=\"%d\" y=\"%d\" style=\"text-anchor: middle\" transform=\"translate(%d, %d) rotate(%d)\">%d cm</text>";
            svg.append(String.format(textRotateTemplate, 0, 0, x1, y1, rotate, wOrL));
        }

        public void addArrowLine(int x, int y, int x2, int y2) {
            svg.append(String.format(arrowTemplate, x, y, x2, y2));
        }

        public void markerDef() {
            String x = "<defs>\n" +
                " <marker \n" +
                " \tid=\"beginArrow\" \n" +
                " \tmarkerWidth=\"12\" \n" +
                " \tmarkerHeight=\"12\" \n" +
                " \trefX=\"0\" \n" +
                " \trefY=\"6\" \n" +
                " \torient=\"auto\">\n" +
                "   <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" +
                " </marker>\n" +
                " <marker \n" +
                " \tid=\"endArrow\" \n" +
                " \tmarkerWidth=\"12\" \n" +
                " \tmarkerHeight=\"12\" \n" +
                " \trefX=\"12\" \n" +
                " \trefY=\"6\" \n" +
                " \torient=\"auto\">\n" +
                "   <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" +
                " </marker>\n" +
                "</defs>";
            svg.append(String.format(x));
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getViewbox() {
            return viewbox;
        }

        public void setViewbox(String viewbox) {
            this.viewbox = viewbox;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return svg.toString() + "</svg>" ;
        }
    }

