# Software Architecture Defect Dataset

This repository contains a dataset of six representative software architecture defect cases, designed and collected for research on automated architecture evaluation and refactoring guidance (e.g., with LLMs and RAG techniques). Each case highlights common design issues and their standard refactoring solutions. The dataset includes both original and semantically rewritten versions to avoid memorization bias when used in language-model-based experiments.

## Overview

- **Purpose**:  
  - Provide a systematic collection of architecture defect examples for reproducibility of experiments on architecture assessment and refactoring suggestion.  
  - Enable studies on LLM-driven or hybrid (LLM + Retrieval-Augmented Generation) workflows that analyze code structure and propose improvements.  
  - Offer both canonical textbook/open-source examples and original, real-world-inspired cases to cover a variety of design problems.

- **Contents**:  
  Six case groups, each illustrating a common design deficiency and its refactoring approach:
  1. **Movie Case** (textbook example)
  2. **E-Book Case** (semantic rewrite of Movie Case)
  3. **GildedRose Case** (public open-source refactoring example)
  4. **Wood Case** (semantic rewrite of GildedRose)
  5. **Order Case** (original, database-normalization-inspired)
  6. **Scene Case** (original, Unity project snippet)

### Movie Case

Source: Refactoring textbook (e.g., Refactoring: Improving the Design of Existing Code, Chapter 1).

Defect: A single method uses a switch-case statement to determine tape types, mixing fee and point calculation logic. This violates the Open-Closed Principle (OCP).

Standard Refactoring: Apply the Strategy pattern to encapsulate different pricing strategies into separate classes. When adding a new tape type, only a new strategy class needs to be added without modifying existing logic.

### E-Book Case

Source: A semantic rewrite of the Movie Case.

Purpose: To prevent language models from leveraging memorized knowledge from training data (which may include the original Movie Case), and instead evaluate whether the model can reason structurally and semantically.

Implementation: Maintains the same structural logic as the original, but renames variables, class names, and descriptive terms to obscure the direct connection to the textbook example.

### GildedRose Case

Source: Publicly available store management example (e.g., GildedRose kata).

Defect: Contains deeply nested if-else statements for updating item quality and sell-in values based on item name. The structure is complex and hard to read, making extensions difficult.

Refactoring: Introduce the Strategy pattern (or a similar approach) to encapsulate update logic for each item type, then dynamically compose them into the item class to improve extensibility.

### Wood Case

Source: A semantic rewrite of the GildedRose Case.

Purpose: Similar to the E-Book Case, this version prevents the model from relying on memory and encourages structural and pattern-based reasoning.

Implementation: Same structure as the GildedRose Case, but all identifiers and descriptions are semantically altered.

### Order Case

Source: An original case inspired by database normalization concepts.

Context: Simulates an order management system involving three classes: Customer, Order, and Employee. Each order is associated with a customer and a responsible employee.

Defect: When an employee leaves, all related orders must be traversed and updated manually. This design is inefficient and lacks flexibility.

Refactoring Idea: Consider centralizing the management of customer-employee relationships (e.g., through a dedicated relation management class), or adopt a more flexible data association model to avoid full traversal updates.

### Scene Case

Source: Snippet from a Unity project developed in the lab.

Context: A single class handles multiple responsibilities with complex command logic and lacks modularity. The extension task is to support a "local object import" feature.

Defect: Responsibilities are overly concentrated, making the system hard to extend or maintain.

Refactoring Suggestion: Introduce the Command pattern to modularize command dispatch logic, and apply the Single Responsibility Principle (SRP) to split classes and improve maintainability and extensibility.
