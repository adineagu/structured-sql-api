# Update the SQL Morph WordPress homepage

[`wordpress-homepage.html`](wordpress-homepage.html) contains Gutenberg block
markup for the homepage body. It uses standard headings, paragraphs, code blocks,
and buttons. Astra supplies typography, colors, spacing, and button styling; no
plugin, script, stylesheet, or hosting change is required.

## Paste and preview

1. Open the HTML file in your text editor and copy its complete contents, including
   the `<!-- wp:... -->` comments. Copy the source text, not a rendered preview.
2. In the existing WordPress Home page editor, open the three-dot menu at the top
   right and select **Code editor**.
3. Replace the existing page-body block markup with the copied contents. Keep the
   page title, permalink, and homepage assignment unchanged. Do not paste this into
   a Custom HTML block or the theme's file editor.
4. Switch back to **Visual editor**. The content should appear as editable blocks.
   If WordPress reports an invalid block, do not save; retain the existing live page
   and inspect the affected block first.
5. Use **Preview** to inspect the page at desktop and mobile widths. Check heading
   spacing, button wrapping, and whether long code lines scroll within their blocks.
6. Check that **See an example** jumps to the example section and that the GitHub
   links open the intended content, including the coding-agent guide and Oracle
   training workflow in **Developing SQL Morph with AI coding agents**.
7. When the preview is ready, click **Save**. This updates the already-published
   homepage. If the public page still shows the stub, purge the Hostinger/WordPress
   page cache and reload it.

## Page title and repository links

The ODI extension section links to `adi.neagu@gmail.com` using a `mailto:` link
with the subject “SQL Morph ODI extension”. It opens the visitor's configured
email application; the visible address can also be copied. No contact-form plugin
is needed.

The body includes an H1 titled **SQL Morph**. If Astra also displays **Home** above
it on the public preview, use Astra's page settings to disable the page title for
this page. The gray title in the editor alone does not establish whether it appears
on the live page.

The walkthrough link uses GitHub's `blob/HEAD/docs/showcase.md`, which follows the
repository's default branch. Before saving the page, ensure that branch contains
the new README, walkthrough, example, `AGENTS.md`, and `docs/agents/workflow.md`.
The AI-assisted development section describes the external-agent experiment,
interactive guidance, documentation improvements, and CHECK runtime fix; it does
not claim autonomous completion or Oracle database execution.
If the work is still on a feature branch,
replace `HEAD` in that link with the branch name, or merge first. The local Git
branch is not automatically reflected in the HTML's links.

## Validation performed locally

Block comment nesting, attribute JSON, local example paths, and the example anchor
can be checked in the source. Final rendering and Gutenberg block validity must be
confirmed in your installed WordPress editor; this file has not been imported into
your site or published by the assistant.
