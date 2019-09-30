package com.vladsch.flexmark.util.visitor;

import com.vladsch.flexmark.util.ast.*;
import org.junit.Test;

import javax.print.Doc;

public class NodeVisitorTest {
    @Test
    public void test_basic() {
    }

    public interface BlockVisitor {
        void visit(Block node);
        void visit(ContentNode node);
    }

    public static class BlockVisitorExt {
        @SuppressWarnings("rawtypes")
        static <V extends BlockVisitor> VisitHandler[] VISIT_HANDLERS(V visitor) {
            return new VisitHandler[] {
                    new VisitHandler<>(Block.class, visitor::visit),
                    new VisitHandler<>(ContentNode.class, visitor::visit),
            };
        }
    }

    static class VisitTester implements BlockVisitor {
        void test() {
            VisitTester self = this;
            NodeVisitor myVisitor = new NodeVisitor(
                    new VisitHandler<>(Document.class, this::visit),
                    new VisitHandler<>(BlankLine.class, this::visit)
            ).addHandlers(BlockVisitorExt.VISIT_HANDLERS(self));
        }

        // generic node handler when specific one is not defined
        public void visit(Node node) {

        }

        public void visit(Block node) {

        }

        public void visit(BlankLine node) {

        }

        public void visit(ContentNode node) {

        }

        public void visit(Document node) {

        }
    }
}
