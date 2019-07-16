package org.jetbrains.kotlin.nj2k.tree.visitors

import org.jetbrains.kotlin.nj2k.tree.*

abstract class JKVisitor {
    abstract fun visitTreeElement(treeElement: JKTreeElement) 
    open fun visitTreeRoot(treeRoot: JKTreeRoot) = visitTreeElement(treeRoot)
    open fun visitDeclaration(declaration: JKDeclaration) = visitTreeElement(declaration)
    open fun visitImportStatement(importStatement: JKImportStatement) = visitTreeElement(importStatement)
    open fun visitImportList(importList: JKImportList) = visitTreeElement(importList)
    open fun visitFile(file: JKFile) = visitTreeElement(file)
    open fun visitClass(klass: JKClass) = visitDeclaration(klass)
    open fun visitInheritanceInfo(inheritanceInfo: JKInheritanceInfo) = visitTreeElement(inheritanceInfo)
    open fun visitAnnotationList(annotationList: JKAnnotationList) = visitTreeElement(annotationList)
    open fun visitAnnotation(annotation: JKAnnotation) = visitAnnotationMemberValue(annotation)
    open fun visitAnnotationParameter(annotationParameter: JKAnnotationParameter) = visitTreeElement(annotationParameter)
    open fun visitAnnotationNameParameter(annotationNameParameter: JKAnnotationNameParameter) = visitAnnotationParameter(annotationNameParameter)
    open fun visitAnnotationListOwner(annotationListOwner: JKAnnotationListOwner) = visitTreeElement(annotationListOwner)
    open fun visitMethod(method: JKMethod) = visitDeclaration(method)
    open fun visitVariable(variable: JKVariable) = visitDeclaration(variable)
    open fun visitForLoopVariable(forLoopVariable: JKForLoopVariable) = visitVariable(forLoopVariable)
    open fun visitLocalVariable(localVariable: JKLocalVariable) = visitVariable(localVariable)
    open fun visitModifierElement(modifierElement: JKModifierElement) = visitTreeElement(modifierElement)
    open fun visitMutabilityModifierElement(mutabilityModifierElement: JKMutabilityModifierElement) = visitModifierElement(mutabilityModifierElement)
    open fun visitModalityModifierElement(modalityModifierElement: JKModalityModifierElement) = visitModifierElement(modalityModifierElement)
    open fun visitVisibilityModifierElement(visibilityModifierElement: JKVisibilityModifierElement) = visitModifierElement(visibilityModifierElement)
    open fun visitOtherModifierElement(otherModifierElement: JKOtherModifierElement) = visitModifierElement(otherModifierElement)
    open fun visitOtherModifiersOwner(otherModifiersOwner: JKOtherModifiersOwner) = visitModifiersListOwner(otherModifiersOwner)
    open fun visitVisibilityOwner(visibilityOwner: JKVisibilityOwner) = visitModifiersListOwner(visibilityOwner)
    open fun visitModalityOwner(modalityOwner: JKModalityOwner) = visitModifiersListOwner(modalityOwner)
    open fun visitMutabilityOwner(mutabilityOwner: JKMutabilityOwner) = visitModifiersListOwner(mutabilityOwner)
    open fun visitModifiersListOwner(modifiersListOwner: JKModifiersListOwner) = visitTreeElement(modifiersListOwner)
    open fun visitTypeElement(typeElement: JKTypeElement) = visitTreeElement(typeElement)
    open fun visitStatement(statement: JKStatement) = visitTreeElement(statement)
    open fun visitBlock(block: JKBlock) = visitTreeElement(block)
    open fun visitBodyStub(bodyStub: JKBodyStub) = visitBlock(bodyStub)
    open fun visitIdentifier(identifier: JKIdentifier) = visitTreeElement(identifier)
    open fun visitNameIdentifier(nameIdentifier: JKNameIdentifier) = visitIdentifier(nameIdentifier)
    open fun visitExpression(expression: JKExpression) = visitTreeElement(expression)
    open fun visitMethodReferenceExpression(methodReferenceExpression: JKMethodReferenceExpression) = visitExpression(methodReferenceExpression)
    open fun visitExpressionStatement(expressionStatement: JKExpressionStatement) = visitStatement(expressionStatement)
    open fun visitDeclarationStatement(declarationStatement: JKDeclarationStatement) = visitStatement(declarationStatement)
    open fun visitOperatorExpression(operatorExpression: JKOperatorExpression) = visitExpression(operatorExpression)
    open fun visitBinaryExpression(binaryExpression: JKBinaryExpression) = visitOperatorExpression(binaryExpression)
    open fun visitUnaryExpression(unaryExpression: JKUnaryExpression) = visitOperatorExpression(unaryExpression)
    open fun visitPrefixExpression(prefixExpression: JKPrefixExpression) = visitUnaryExpression(prefixExpression)
    open fun visitPostfixExpression(postfixExpression: JKPostfixExpression) = visitUnaryExpression(postfixExpression)
    open fun visitQualifiedExpression(qualifiedExpression: JKQualifiedExpression) = visitExpression(qualifiedExpression)
    open fun visitTypeArgumentList(typeArgumentList: JKTypeArgumentList) = visitTreeElement(typeArgumentList)
    open fun visitTypeArgumentListOwner(typeArgumentListOwner: JKTypeArgumentListOwner) = visitTreeElement(typeArgumentListOwner)
    open fun visitMethodCallExpression(methodCallExpression: JKMethodCallExpression) = visitExpression(methodCallExpression)
    open fun visitFieldAccessExpression(fieldAccessExpression: JKFieldAccessExpression) = visitAssignableExpression(fieldAccessExpression)
    open fun visitPackageAccessExpression(packageAccessExpression: JKPackageAccessExpression) = visitAssignableExpression(packageAccessExpression)
    open fun visitClassAccessExpression(classAccessExpression: JKClassAccessExpression) = visitExpression(classAccessExpression)
    open fun visitArrayAccessExpression(arrayAccessExpression: JKArrayAccessExpression) = visitAssignableExpression(arrayAccessExpression)
    open fun visitParenthesizedExpression(parenthesizedExpression: JKParenthesizedExpression) = visitExpression(parenthesizedExpression)
    open fun visitTypeCastExpression(typeCastExpression: JKTypeCastExpression) = visitExpression(typeCastExpression)
    open fun visitExpressionList(expressionList: JKExpressionList) = visitTreeElement(expressionList)
    open fun visitArgument(argument: JKArgument) = visitTreeElement(argument)
    open fun visitNamedArgument(namedArgument: JKNamedArgument) = visitArgument(namedArgument)
    open fun visitArgumentList(argumentList: JKArgumentList) = visitTreeElement(argumentList)
    open fun visitLiteralExpression(literalExpression: JKLiteralExpression) = visitExpression(literalExpression)
    open fun visitParameter(parameter: JKParameter) = visitVariable(parameter)
    open fun visitStringLiteralExpression(stringLiteralExpression: JKStringLiteralExpression) = visitLiteralExpression(stringLiteralExpression)
    open fun visitStubExpression(stubExpression: JKStubExpression) = visitExpression(stubExpression)
    open fun visitLoopStatement(loopStatement: JKLoopStatement) = visitStatement(loopStatement)
    open fun visitBlockStatement(blockStatement: JKBlockStatement) = visitStatement(blockStatement)
    open fun visitBlockStatementWithoutBrackets(blockStatementWithoutBrackets: JKBlockStatementWithoutBrackets) = visitStatement(blockStatementWithoutBrackets)
    open fun visitThisExpression(thisExpression: JKThisExpression) = visitExpression(thisExpression)
    open fun visitSuperExpression(superExpression: JKSuperExpression) = visitExpression(superExpression)
    open fun visitWhileStatement(whileStatement: JKWhileStatement) = visitLoopStatement(whileStatement)
    open fun visitDoWhileStatement(doWhileStatement: JKDoWhileStatement) = visitLoopStatement(doWhileStatement)
    open fun visitBreakStatement(breakStatement: JKBreakStatement) = visitStatement(breakStatement)
    open fun visitBreakWithLabelStatement(breakWithLabelStatement: JKBreakWithLabelStatement) = visitBreakStatement(breakWithLabelStatement)
    open fun visitIfStatement(ifStatement: JKIfStatement) = visitStatement(ifStatement)
    open fun visitIfElseStatement(ifElseStatement: JKIfElseStatement) = visitIfStatement(ifElseStatement)
    open fun visitIfElseExpression(ifElseExpression: JKIfElseExpression) = visitExpression(ifElseExpression)
    open fun visitAssignableExpression(assignableExpression: JKAssignableExpression) = visitExpression(assignableExpression)
    open fun visitLambdaExpression(lambdaExpression: JKLambdaExpression) = visitExpression(lambdaExpression)
    open fun visitDelegationConstructorCall(delegationConstructorCall: JKDelegationConstructorCall) = visitMethodCallExpression(delegationConstructorCall)
    open fun visitLabel(label: JKLabel) = visitTreeElement(label)
    open fun visitLabelEmpty(labelEmpty: JKLabelEmpty) = visitLabel(labelEmpty)
    open fun visitLabelText(labelText: JKLabelText) = visitLabel(labelText)
    open fun visitContinueStatement(continueStatement: JKContinueStatement) = visitStatement(continueStatement)
    open fun visitLabeledStatement(labeledStatement: JKLabeledStatement) = visitExpression(labeledStatement)
    open fun visitEmptyStatement(emptyStatement: JKEmptyStatement) = visitStatement(emptyStatement)
    open fun visitTypeParameterList(typeParameterList: JKTypeParameterList) = visitTreeElement(typeParameterList)
    open fun visitTypeParameter(typeParameter: JKTypeParameter) = visitTreeElement(typeParameter)
    open fun visitTypeParameterListOwner(typeParameterListOwner: JKTypeParameterListOwner) = visitTreeElement(typeParameterListOwner)
    open fun visitEnumConstant(enumConstant: JKEnumConstant) = visitVariable(enumConstant)
    open fun visitForInStatement(forInStatement: JKForInStatement) = visitStatement(forInStatement)
    open fun visitPackageDeclaration(packageDeclaration: JKPackageDeclaration) = visitDeclaration(packageDeclaration)
    open fun visitClassLiteralExpression(classLiteralExpression: JKClassLiteralExpression) = visitExpression(classLiteralExpression)
    open fun visitAnnotationMemberValue(annotationMemberValue: JKAnnotationMemberValue) = visitTreeElement(annotationMemberValue)
    open fun visitField(field: JKField) = visitVariable(field)
    open fun visitJavaField(javaField: JKJavaField) = visitField(javaField)
    open fun visitJavaMethod(javaMethod: JKJavaMethod) = visitMethod(javaMethod)
    open fun visitJavaMethodCallExpression(javaMethodCallExpression: JKJavaMethodCallExpression) = visitMethodCallExpression(javaMethodCallExpression)
    open fun visitClassBody(classBody: JKClassBody) = visitTreeElement(classBody)
    open fun visitEmptyClassBody(emptyClassBody: JKEmptyClassBody) = visitClassBody(emptyClassBody)
    open fun visitJavaNewExpression(javaNewExpression: JKJavaNewExpression) = visitExpression(javaNewExpression)
    open fun visitJavaDefaultNewExpression(javaDefaultNewExpression: JKJavaDefaultNewExpression) = visitExpression(javaDefaultNewExpression)
    open fun visitJavaNewEmptyArray(javaNewEmptyArray: JKJavaNewEmptyArray) = visitExpression(javaNewEmptyArray)
    open fun visitJavaNewArray(javaNewArray: JKJavaNewArray) = visitExpression(javaNewArray)
    open fun visitJavaLiteralExpression(javaLiteralExpression: JKJavaLiteralExpression) = visitLiteralExpression(javaLiteralExpression)
    open fun visitReturnStatement(returnStatement: JKReturnStatement) = visitStatement(returnStatement)
    open fun visitJavaAssertStatement(javaAssertStatement: JKJavaAssertStatement) = visitStatement(javaAssertStatement)
    open fun visitJavaForLoopStatement(javaForLoopStatement: JKJavaForLoopStatement) = visitLoopStatement(javaForLoopStatement)
    open fun visitJavaPolyadicExpression(javaPolyadicExpression: JKJavaPolyadicExpression) = visitExpression(javaPolyadicExpression)
    open fun visitJavaAssignmentExpression(javaAssignmentExpression: JKJavaAssignmentExpression) = visitExpression(javaAssignmentExpression)
    open fun visitJavaThrowStatement(javaThrowStatement: JKJavaThrowStatement) = visitStatement(javaThrowStatement)
    open fun visitJavaTryStatement(javaTryStatement: JKJavaTryStatement) = visitStatement(javaTryStatement)
    open fun visitJavaTryCatchSection(javaTryCatchSection: JKJavaTryCatchSection) = visitTreeElement(javaTryCatchSection)
    open fun visitJavaSwitchStatement(javaSwitchStatement: JKJavaSwitchStatement) = visitStatement(javaSwitchStatement)
    open fun visitJavaSwitchCase(javaSwitchCase: JKJavaSwitchCase) = visitTreeElement(javaSwitchCase)
    open fun visitJavaDefaultSwitchCase(javaDefaultSwitchCase: JKJavaDefaultSwitchCase) = visitJavaSwitchCase(javaDefaultSwitchCase)
    open fun visitJavaLabelSwitchCase(javaLabelSwitchCase: JKJavaLabelSwitchCase) = visitJavaSwitchCase(javaLabelSwitchCase)
    open fun visitJavaContinueStatement(javaContinueStatement: JKJavaContinueStatement) = visitStatement(javaContinueStatement)
    open fun visitJavaSynchronizedStatement(javaSynchronizedStatement: JKJavaSynchronizedStatement) = visitStatement(javaSynchronizedStatement)
    open fun visitJavaAnnotationMethod(javaAnnotationMethod: JKJavaAnnotationMethod) = visitMethod(javaAnnotationMethod)
    open fun visitJavaStaticInitDeclaration(javaStaticInitDeclaration: JKJavaStaticInitDeclaration) = visitDeclaration(javaStaticInitDeclaration)
    open fun visitKtGetterOrSetter(ktGetterOrSetter: JKKtGetterOrSetter) = visitTreeElement(ktGetterOrSetter)
    open fun visitKtEmptyGetterOrSetter(ktEmptyGetterOrSetter: JKKtEmptyGetterOrSetter) = visitKtGetterOrSetter(ktEmptyGetterOrSetter)
    open fun visitKtProperty(ktProperty: JKKtProperty) = visitField(ktProperty)
    open fun visitKtFunction(ktFunction: JKKtFunction) = visitMethod(ktFunction)
    open fun visitKtConstructor(ktConstructor: JKKtConstructor) = visitMethod(ktConstructor)
    open fun visitKtPrimaryConstructor(ktPrimaryConstructor: JKKtPrimaryConstructor) = visitKtConstructor(ktPrimaryConstructor)
    open fun visitKtAssignmentStatement(ktAssignmentStatement: JKKtAssignmentStatement) = visitStatement(ktAssignmentStatement)
    open fun visitKtCall(ktCall: JKKtCall) = visitMethodCallExpression(ktCall)
    open fun visitKtMethodCallExpression(ktMethodCallExpression: JKKtMethodCallExpression) = visitMethodCallExpression(ktMethodCallExpression)
    open fun visitKtAlsoCallExpression(ktAlsoCallExpression: JKKtAlsoCallExpression) = visitKtMethodCallExpression(ktAlsoCallExpression)
    open fun visitKtLiteralExpression(ktLiteralExpression: JKKtLiteralExpression) = visitLiteralExpression(ktLiteralExpression)
    open fun visitKtWhenStatement(ktWhenStatement: JKKtWhenStatement) = visitStatement(ktWhenStatement)
    open fun visitKtWhenCase(ktWhenCase: JKKtWhenCase) = visitTreeElement(ktWhenCase)
    open fun visitKtWhenLabel(ktWhenLabel: JKKtWhenLabel) = visitTreeElement(ktWhenLabel)
    open fun visitKtElseWhenLabel(ktElseWhenLabel: JKKtElseWhenLabel) = visitKtWhenLabel(ktElseWhenLabel)
    open fun visitKtValueWhenLabel(ktValueWhenLabel: JKKtValueWhenLabel) = visitKtWhenLabel(ktValueWhenLabel)
    open fun visitKtIsExpression(ktIsExpression: JKKtIsExpression) = visitExpression(ktIsExpression)
    open fun visitKtInitDeclaration(ktInitDeclaration: JKKtInitDeclaration) = visitDeclaration(ktInitDeclaration)
    open fun visitKtConvertedFromForLoopSyntheticWhileStatement(ktConvertedFromForLoopSyntheticWhileStatement: JKKtConvertedFromForLoopSyntheticWhileStatement) = visitStatement(ktConvertedFromForLoopSyntheticWhileStatement)
    open fun visitKtThrowExpression(ktThrowExpression: JKKtThrowExpression) = visitExpression(ktThrowExpression)
    open fun visitKtTryExpression(ktTryExpression: JKKtTryExpression) = visitExpression(ktTryExpression)
    open fun visitKtTryCatchSection(ktTryCatchSection: JKKtTryCatchSection) = visitTreeElement(ktTryCatchSection)
    open fun visitKtAnnotationArrayInitializerExpression(ktAnnotationArrayInitializerExpression: JKKtAnnotationArrayInitializerExpression) = visitExpression(ktAnnotationArrayInitializerExpression)
}
