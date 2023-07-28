public class Main {
    public static void main(String[] args) {

        int randomDirection = (int) (Math.random() * 3 + 1);
        int startX = (int) (Math.random() * 20 - 10);
        int startY = (int) (Math.random() * 20 - 10);
        int finishX = (int) (Math.random() * 20 - 10);
        int finishY = (int) (Math.random() * 20 - 10);
        System.out.println(
                "Где робот начал:\nx = " + startX + ", y = " + startY + "\n\n" +
                "Где робот должен закончить: \nx = " + finishX + ", y = " + finishY + "\n");

        Robot robot = switch (randomDirection) {
            case 1 -> new Robot(startX, startY, Direction.DOWN);
            case 2 -> new Robot(startX, startY, Direction.RIGHT);
            case 3 -> new Robot(startX, startY, Direction.UP);
            case 4 -> new Robot(startX, startY, Direction.LEFT);
            default -> throw new IllegalStateException("Unexpected value: " + randomDirection);
        };
        moveRobot(robot, finishX, finishY);
        gde(robot);
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        private int x;
        private int y;
        private Direction dir;

        public Robot(int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {
            return dir;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void turnLeft() {
            if (dir == Direction.UP) {
                dir = Direction.LEFT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.DOWN;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.UP;
            }
        }

        public void turnRight() {
            if (dir == Direction.UP) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.LEFT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.UP;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.DOWN;
            }
        }

        public void stepForward() {
            if (dir == Direction.UP) {
                y++;
            }
            if (dir == Direction.DOWN) {
                y--;
            }
            if (dir == Direction.LEFT) {
                x--;
            }
            if (dir == Direction.RIGHT) {
                x++;
            }
        }
    }


    public static void moveRobot(Robot robot, int toX, int toY) {
        while (robot.getX() != toX || robot.getY() != toY) {
            Direction dir;
            if (robot.getX() < toX) {
                dir = Direction.RIGHT;
            } else {
                dir = Direction.LEFT;
            }
            while (robot.getDirection() != dir) {
                robot.turnRight();
            }
            robot.stepForward();
            if (robot.getY() < toY) {
                dir = Direction.UP;
            } else {
                dir = Direction.DOWN;
            }
            while (robot.getDirection() != dir) {
                robot.turnRight();
            }
            robot.stepForward();
        }



    }


    public static void gde (Robot robot) {
        System.out.println("Робот находится здесь:\nx = " + robot.getX() + ", y = " + robot.getY());
    }
}