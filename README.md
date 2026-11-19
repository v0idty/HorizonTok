# HorizonTok

HorizonTok is an independent Android-first prototype focused on a usable, fresh-content feed experience.

## Goal
Avoid presenting stale content as current. The app should distinguish:
- **Live content**: content returned by a configured, authorized source.
- **Cached content**: content saved locally, with its original date clearly shown.
- **Empty feed**: source returned no items.
- **Source unavailable**: a source failed, while connectivity may still exist.
- **Offline**: confirmed device connectivity loss.

## Current prototype
- Mobile-first feed UI and status states.
- Demo content is labeled as demo; it is not a live TikTok feed.
- No account login, scraping, SIM-region spoofing, or TikTok restriction bypass.

## Roadmap
1. Build the independent mobile feed UI.
2. Add authorized content providers / user-configured feeds.
3. Show source, publication date, and freshness clearly.
4. Add retry and fallback behavior that never falsely reports device-wide internet failure.

## Run
Open `index.html` in a browser. This is a front-end prototype only; it does not fetch real video content yet.
