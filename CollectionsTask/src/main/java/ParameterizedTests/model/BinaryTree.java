package ParameterizedTests.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BinaryTree {

    private BinaryTree leftBranch;
    private BinaryTree rightBranch;
}
