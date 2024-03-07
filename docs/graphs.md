## Graph Theory

Graph Theory is the study of grapghs and its algorithms, where graphs are
mathematical structures used to models pairwise relation of objects.

Given a graph G(V, E) is a graph of `V` vertices (nodes) and are connected by E
edges (links).

Graph Theory might sound intimidating at first, but it's actually a pretty cool
and straightforward concept once you break it down. Let's simplify it:

Imagine you have a bunch of dots (which we call vertices or nodes) and you
connect some of these dots with lines (edges or links). This whole setup of dots
and lines is what we call a graph in Graph Theory. These dots can represent
anything, like cities, and the lines might represent roads connecting those
cities.

So, when you hear someone talk about "Graph Theory," they're talking about
studying these dot-and-line structures. They look at how the dots are connected
by the lines and try to find patterns, solve problems like finding the shortest
path from one dot to another, or figure out if you can visit every dot without
crossing the same line twice.

For example, let's say each dot represents a person, and each line represents a
friendship between two people. Graph Theory can help us understand questions
like "Is there a way for a message from any one person to reach any other person
through a chain of friends?" or "Who is the most connected person?"

Here's a simple graph breakdown:

G(V, E): This is just a fancy way of saying we have a graph named G. The graph
is made up of V (vertices or dots) and E (edges or lines). For example, if we
have a graph with 4 people (dots) and 3 friendships (lines) connecting some of
them, we might describe this as G(4, 3) where V = 4 and E = 3. Graph Theory is a
powerful tool because it can model so many different things in the real world,
from social networks to how the internet is connected, without getting bogged
down in too many details. It's all about the connections!

<svg xmlns="http://www.w3.org/2000/svg" width="300" height="200">
	<circle cx="150" cy="50" r="30" fill="lightblue"/>
	<text x="150" y="55" fill="black" style="text-anchor: middle; font-size: 12px">Graph</text>
	<circle cx="80" cy="150" r="40" fill="lightgreen"/>
	<text x="80" y="155" fill="black" style="text-anchor: middle; font-size: 12px">Directed</text>
	<circle cx="220" cy="150" r="45" fill="lightcoral"/>
	<text x="220" y="155" fill="black" style="text-anchor: middle; font-size: 12px">Undirected</text>
	<line x1="150" y1="80" x2="80" y2="110" stroke="black"/>
	<line x1="150" y1="80" x2="220" y2="110" stroke="black"/>
</svg>

There are two types of graphs - **Directed(edges has a direction)** and
**Undirected(edges do not have a direction and generally considered
bi-directional)**

### Types of Graphs:

1. Trees: Undirected graph where any two vertices are connected by a single
   edge.
2. Forest: Undirected graph where connected component is a tree. Its is disjoint
   union of trees. Layman term - MULTIPLE INDEPENDENT TREES
3. Directed Acyclic Graphs: Directed finite graph with no directed cycles. -
   Layman term - NO CYCLES !!
4. Complete Graph - All nodes are connected to all other nodes.

### Representations of Graph

1. Adjacency List representation: Assign an array to every single vertex, and
   each array stores the edges for that vertex.

- Space efficient when dealing with **sparse graph** but not for a dense graph.
- Iterating over all edges is fast
- but edge weight lookup is slow and O(E) operations.

Simple idea: use a list to represents the edges for each vertex.

2. Adjacency Matrix representation: A matrix representation of the graph.
   Consider a `V * V` matrix to define a graph with `V` vertices. `matrix[i][j]`
   is the weight of the edge when we travel from `i -> j`.

- Space efficient with **dense graphs**, but requires O(V<sup>2</sup>) space.
- Iterating over all edges is slow and takes O(E<sup>2</sup>) time.
- but edge weight lookup is fast O(1) time.

Example Graph:

<svg xmlns="http://www.w3.org/2000/svg" width="300" height="200">
  <defs>
    <marker id="arrowhead" markerWidth="10" markerHeight="7" refX="10" refY="3.5" orient="auto" markerUnits="strokeWidth">
      <path d="M0,0 L0,7 L10,3.5 z" fill="black"/>
    </marker>
  </defs>
  <line x1="50" y1="50" x2="50" y2="150" stroke="black" marker_end="url(#arrowhead)"/>
  <text x="50" y="95" fill="red" style="text-anchor: middle; font-size: 12px">4</text>
  <line x1="50" y1="50" x2="250" y2="50" stroke="black" marker_end="url(#arrowhead)"/>
  <text x="150" y="45" fill="red" style="text-anchor: middle; font-size: 12px">2</text>
  <line x1="250" y1="50" x2="250" y2="150" stroke="black" marker_end="url(#arrowhead)"/>
  <text x="250" y="95" fill="red" style="text-anchor: middle; font-size: 12px">3</text>
  <circle cx="50" cy="50" r="20" fill="lightblue"/>
  <text x="50" y="55" fill="black" style="text-anchor: middle; font-size: 12px">A</text>
  <circle cx="250" cy="50" r="20" fill="lightblue"/>
  <text x="250" y="55" fill="black" style="text-anchor: middle; font-size: 12px">B</text>
  <circle cx="50" cy="150" r="20" fill="lightblue"/>
  <text x="50" y="155" fill="black" style="text-anchor: middle; font-size: 12px">C</text>
  <circle cx="250" cy="150" r="20" fill="lightblue"/>
  <text x="250" y="155" fill="black" style="text-anchor: middle; font-size: 12px">D</text>
</svg>

Adjacency List Representation:

```
A: [(2, B), (4, C)]
B: [(3, D)]
C: []
D: []
```

Adjacency Matrix Representation:

> $$
> \begin{bmatrix}
>   0 & 2 & 4 & 0 \\
>   0 & 0 & 0 & 3 \\
>   0 & 0 & 0 & 0 \\
>   0 & 0 & 0 & 0 \\
> \end{bmatrix}
> $$
